package chap27reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Reflect05CreateArray {
    public static void main(String[] args) throws ClassNotFoundException {
        method();
    }
    // 反射操控一位数组
    public static void method() throws ClassNotFoundException {
        Class<?> classType = Class.forName("java.lang.String");
        String[] o = (String[]) Array.newInstance(classType, 10);
        Object o2 = Array.newInstance(classType, 10);
        // 索引为5的元素设置为hello
        Array.set(o, 5, "hello");
        Object o1 = Array.get(o, 5);
        System.out.println(Arrays.toString(o));
    }

}
