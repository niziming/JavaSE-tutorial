package chap27reflect.kuangstudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test06 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test3() {
        try {
            Class<?> aClass = Class.forName("chap27reflect.kuangstudy.User");
            Constructor<?> constructor = aClass.getConstructor();
            Object o = constructor.newInstance();
            Method getId = aClass.getDeclaredMethod("getId");
            getId.setAccessible(true);
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000 * 1000; i++) getId.invoke(o, null);
            System.out.printf("%-2dms\n", (System.currentTimeMillis() - start));
        } catch (IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try {
            Class<?> aClass = Class.forName("chap27reflect.kuangstudy.User");
            Constructor<?> constructor = aClass.getConstructor();
            Object o = constructor.newInstance();
            Method getId = aClass.getDeclaredMethod("getId");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000 * 1000 * 1000; i++) getId.invoke(o, null);
            System.out.printf("%-2dms\n", (System.currentTimeMillis() - start));
        } catch (IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        User user = new User();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 1000 * 1000; i++) user.getName();
        System.out.printf("%-2dms\n", (System.currentTimeMillis() - start));
    }
}
