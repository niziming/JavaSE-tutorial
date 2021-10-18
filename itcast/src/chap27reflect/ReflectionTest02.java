package chap27reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest02 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        // 动态加载类的运行时对象
        try {
            Class<?> c = Class.forName("java.lang.String");
            // 获取成员方法集和
            Method[] declaredMethods = c.getDeclaredMethods();
            for (Method m : declaredMethods) {
                // 打印权限修饰符
                System.out.print(Modifier.toString(m.getModifiers()));
                // 打印返回值类型名称
                System.out.print(" " + m.getReturnType().getSimpleName() + " ");
                System.out.println(m.getName() + "()");
            }
        }catch (ClassNotFoundException e) {
            System.out.println("找不到指定类");
            e.printStackTrace();
        }
    }

}
