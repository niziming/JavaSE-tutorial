package chap27reflect.kuangstudy;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test04 {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("itcast.chap27reflect.kuangstudy.User");
            System.out.println("aClass.getName() = " + aClass.getName());
            System.out.println("aClass.getSimpleName() = " + aClass.getSimpleName());
            System.out.println("aClass.getPackageName() = " + aClass.getPackageName());
            System.out.println("aClass.getFields() = " + Arrays.toString(aClass.getFields()));
            System.out.println("aClass.getFields() = " + Arrays.toString(aClass.getDeclaredFields()));
            Field name = aClass.getDeclaredField("name");
            System.out.println("name = " + name);
            System.out.println("aClass.getDeclaredMethods() = " + Arrays.toString(aClass.getDeclaredMethods())) ;
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
