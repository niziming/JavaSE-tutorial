package itcast.chap26reflect.demo;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("itcast.chap26reflect.demo.HelloService");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            if (name.equals("getTime")) {
                Object invoke = method.invoke(new HelloServiceImpl());
                System.out.println(invoke);
            } else {
                Object hello = method.invoke(new HelloServiceImpl(), "hello");
                System.out.println(hello);
            }
        }
        Object invoke = aClass.getMethod("getTime").invoke(new HelloServiceImpl());
        Object invoke1 = aClass.getMethod("echo", String.class).invoke(new HelloServiceImpl(), "nihaoa");
        System.out.println(invoke);
        System.out.println(invoke1);
    }
}
