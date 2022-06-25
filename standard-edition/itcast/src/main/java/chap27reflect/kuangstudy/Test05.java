package chap27reflect.kuangstudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("chap27reflect.kuangstudy.User");
            Object o = aClass.newInstance();
            System.out.println("o = " + o);
            Constructor declaredConstructor = aClass.getDeclaredConstructor(null);
            Object o1 = declaredConstructor.newInstance(null);
            System.out.println("o1 = " + o1);
            Method setName = aClass.getDeclaredMethod("setName", String.class);
            setName.invoke(o, "ziming");
            System.out.println("o = " + o);
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            System.out.println("name = " + name);
            name.set(o, "lixueq");
            System.out.println("o = " + o);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
