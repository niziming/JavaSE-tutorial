package itcast.chap26reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodDemo01 {
    public static void main(String[] args) {
        Book book = new Book("JavaSE", 1, 100);
        book.print();
        // 获取所有方法
        Method[] methods = book.getClass().getMethods();
        for (Method method : methods) {
            // System.out.println("方法对象: " + creadThread);
            System.out.println("方法名称: " + method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(Arrays.toString(parameterTypes));
            }
            System.out.println("--------------------------");
        }
    }
}
