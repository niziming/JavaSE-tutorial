package cn.zm;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class Reflection {

  // 反射基本操作
  public static class TargetObject {
    private String value;

    TargetObject() {
      this.value = "TargetObject";
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
      Class clazz = TargetObject.class;
      TargetObject o = (TargetObject) clazz.newInstance();

      Field[] declaredFields = clazz.getDeclaredFields();
      System.out.println("Arrays.toString(declaredFields) = " + Arrays.toString(declaredFields));

      Method[] declaredMethods = clazz.getDeclaredMethods();
      System.out.println("Arrays.toString(declaredMethods) = " + Arrays.toString(declaredMethods));

      Method publicMethod = clazz.getDeclaredMethod("publicMethod", String.class);
      publicMethod.invoke(o, "public Method");

    }

    private static void publicMethod(String value) {
      System.out.println("hello " + value);

    }

    private static void privateMethod() {
    }
  }

  // 获取类的 四种方法
  public static class ClassCreate {
    public static void main(String[] args) {
      Class clazz = ClassCreate.class;
      System.out.println(clazz);

      Class<?> aClass = new ClassCreate().getClass();
      System.out.println(aClass);

      try {
        // 内部类无法获取
        // Class<?> aClass1 = Class.forName("cn.zm.basis.Reflection.ClassCreate");
        Class<?> aClass1 = Class.forName("cn.zm.Reflection");
        System.out.println(aClass1);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      try {
        final Class<?> aClass1 = ClassLoader.getSystemClassLoader().loadClass("cn.zm.Reflection");
        System.out.println(aClass1);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }


  }


  //region 静态代理
  // 静态代理实现步骤:
  // 定义一个接口及其实现类；
  // 创建一个代理类同样实现这个接口
  // 将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法。这样的话，我们就可以通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些自己想做的事情。
  public static class StaticProxy {
    public static void main(String[] args) {
      SmsService smsService = new SmsServiceImpl();
      SmsProxy smsProxy = new SmsProxy(smsService);
      smsProxy.sendSms("smsProxy");
    }

    // 创建一个代理类同样实现这个接口
    static class SmsProxy implements SmsService {
      private final SmsService smsService;

      SmsProxy(SmsService smsService) {
        this.smsService = smsService;
      }

      @Override
      public void sendSms(String msg) {
        System.out.println("代理前可以进行的操作");
        smsService.sendSms(msg);
        System.out.println("代理后可以进行的操作");
      }
    }

    // 定义一个接口其实现类；
    static class SmsServiceImpl implements SmsService {
      @Override
      public void sendSms(String msg) {
        System.out.println("send sms " + msg);
      }
    }

    // 定义一个接口
    interface SmsService {
      void sendSms(String msg);
    }
  }
  //endregion


  //region 动态代理
  public static class ActiveProxy {

    //region 2.CGLIB 动态代理
    // JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类。
    // 为了解决这个问题，我们可以用 CGLIB 动态代理机制来避免。
    static class CGLIBProxy {

      public static void main(String[] args) {
        AliSmsService proxy = CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("cglib");
        TencentSmsService tss = CglibProxyFactory.getProxy(TencentSmsService.class);
        tss.tSend("我是腾讯邮件");

      }

      // 3.获取代理类
      static class CglibProxyFactory <C> {
        public static <C> C getProxy(Class<?> clazz) {
          // 创建动态代理增强类
          Enhancer enhancer = new Enhancer();
          // 设置类加载器
          enhancer.setClassLoader(clazz.getClassLoader());
          // 设置被代理类
          enhancer.setSuperclass(clazz);
          // 设置方法拦截器
          enhancer.setCallback(new MyMethodInterceptor());
          // 创建代理类
          return (C) enhancer.create();
        }
      }

      //region 2.自定义 MethodInterceptor（方法拦截器）
      static class MyMethodInterceptor implements MethodInterceptor {
        // obj :被代理的对象（需要增强的对象）
        // method :被拦截的方法（需要增强的方法）
        // args :方法入参
        // proxy :用于调用原始方法
        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
          System.out.println("增强前 = " + method.getName());
          Annotation[] annotations = method.getDeclaredAnnotations();
          for (Annotation annotation : annotations) {
            System.out.println(annotation);
          }

          Object o1 = methodProxy.invokeSuper(o, args);
          System.out.println("增强后 = " + method.getName());
          return o1;
        }
      }
      //endregion

      //region 1.实现一个使用阿里云发送短信的类
      static class AliSmsService {
        public String send(String msg) {
          System.out.println("send sms " + msg);
          return "send sms " + msg;
        }
      }
      //endregion

      //region 1.1实现一个使用阿里云发送短信的类
      static class TencentSmsService {
        @MyAnno
        public String tSend(String msg) {
          System.out.println("TencentSmsService sms " + msg);
          return "TencentSmsService sms " + msg;
        }
      }
      //endregion

    }
    //endregion

    //region 1.JDK 动态代理机制
    // JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类。
    // 在 Java 动态代理机制中 InvocationHandler 接口和 Proxy 类是核心。
    static class JdkProxy {
      public static void main(String[] args) {
        SmsService proxy = JdkProxyFactory.getProxy(new SmsServiceImpl());
        proxy.sendSms("jdkProxy");

        SmsService proxy1 = JdkProxyFactory.getProxy(new IphoneSms());
        proxy1.sendSms("jdkProxy1");
      }

      //region 4.获取代理对象的工厂类
      static class JdkProxyFactory<C> {
        public static <C> C getProxy(Object target) {
          return (C) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new SmsProxy(target)
          );
        }
      }
      //endregion

      //region 3.定义一个 JDK 动态代理类
      static class SmsProxy implements InvocationHandler {
        /**
         * 代理类中的真实对象
         */
        private final Object target;

        public SmsProxy(Object target) {
          this.target = target;
        }

        /**
         * @param proxy  动态生成的代理类
         * @param method 与代理类对象调用的方法相对应
         * @param args   当前 method 方法的参数
         * @return java.lang.Object
         * @author 十渊
         * @date 2022/3/28 11:28
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          //调用方法之前，我们可以添加自己的操作
          System.out.println("before invoke" + method.getName());
          Object result = method.invoke(target, args);
          //调用方法之后，我们同样可以添加自己的操作
          System.out.println("after invoke" + method.getName());
          return result;
        }
      }
      //endregion

      //region 2.实现发送短信的接口
      static class SmsServiceImpl implements SmsService {
        @Override
        public String sendSms(String msg) {
          System.out.println("send sms " + msg);
          return msg;
        }
      }
      //endregion


      //region 2.1 iphone send msg
      static class IphoneSms implements SmsService {

        @Override
        public String sendSms(String msg) {
          System.out.println("iphone " + msg);
          return msg;
        }
      }
      //endregion

      //region 1.定义发送短信的接口
      interface SmsService {
        String sendSms(String msg);
      }
      //endregion
    }
    //endregion

  }
  //endregion

}
