package cn.zm.basis;


import java.lang.reflect.*;
import java.util.Arrays;

public class Reflection {

  // 反射基本操作
  public static class TargetObject {
    private String value;
    TargetObject () {
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

    private static void privateMethod() {}
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
        Class<?> aClass1 = Class.forName("cn.zm.basis.Reflection");
        System.out.println(aClass1);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      try {
        final Class<?> aClass1 = ClassLoader.getSystemClassLoader().loadClass("cn.zm.basis.Reflection");
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

    //region 1.JDK 动态代理机制
    // 在 Java 动态代理机制中 InvocationHandler 接口和 Proxy 类是核心。
    static class JdkProxy {



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
         * @param proxy 动态生成的代理类
         * @param method 与代理类对象调用的方法相对应
         * @param args 当前 method 方法的参数
         * @author 十渊
         * @date 2022/3/28 11:28
         * @return java.lang.Object
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

      //region 1.定义发送短信的接口
      interface SmsService {        String sendSms(String msg);      }
      //endregion
    }
    //endregion

  }
  //endregion

}
