package cn.zm.basis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Reflection {

  static class DebugInvocHandler implements InvocationHandler {
    private final Object target;

    public DebugInvocHandler(Object target) {
      this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      System.out.println("before invoke" + method.getName());
      Object invoke = method.invoke(target, args);
      System.out.println("after invoke" + method.getName());
      return invoke;
    }
  }

  static class Obj {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  public static void main(String[] args) {
    DebugInvocHandler dh = new DebugInvocHandler(new Obj());
    Object o = Proxy.newProxyInstance(
      DebugInvocHandler.class.getClassLoader(),
      DebugInvocHandler.class.getInterfaces(),
      dh
    );
    Obj obj = (Obj) o;
    ((Obj) o).getName();
  }

}
