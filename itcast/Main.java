package itcast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    // 循环次数定义: 10亿次
    private static final int loopCnt = 1000 * 1000 * 1000;

    static class Person {
        private int age = 20;

        public int getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        // method();
        // method2();
        // method3();
        // method4();
        method5();
    }

    // 每次重新生成对象
    public static void method() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopCnt; i++) {
            Person person = new Person();
            person.setAge(32);
        }
        long end = System.currentTimeMillis();
        System.out.println("循环10亿次创建对象的时间：" + (end - start));
    }

    // 循环10亿次创建对象赋值的时间
    public static void method2() {
        long start = System.currentTimeMillis();
        Person person = new Person();
        for (int i = 0; i < loopCnt; i++) {
            person.setAge(32);
        }
        long end = System.currentTimeMillis();
        System.out.println("循环10亿次创建对象赋值的时间：" + (end - start));
    }

    //使用反射创建对象
    public static void method3() {
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < loopCnt; i++) {
                Class<Person> personClass = Person.class;
                Person person = personClass.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("循环10亿次反射创建对象的时间：" + (end - start));
    }
    //使用反射创建对象和方法并执行
    public static void method4() {
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < loopCnt; i++) {
                Class<Person> personClass = Person.class;
                Person person = personClass.newInstance();
                Method setAge = personClass.getMethod("setAge", Integer.class);
                setAge.invoke(person, 32);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("循环10亿次反射创建对象的时间：" + (end - start));
    }
    //使用创建对象反射执行对象方法
    public static void method5() {
        long start = System.currentTimeMillis();
        Class<Person> personClass = Person.class;
        Person person = null;

        try {
            person = personClass.newInstance();
            Method setAge = personClass.getMethod("setAge", Integer.class);
            for (int i = 0; i < loopCnt; i++) {
                setAge.invoke(person, 32);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("循环10亿次反射创建对象的时间：" + (end - start));
    }
}
