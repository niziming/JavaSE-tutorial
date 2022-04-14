package chap27reflect.kuangstudy;

public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("parent = " + parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println("parent1 = " + parent1);

        ClassLoader classLoader = Class.forName("chap27reflect.kuangstudy.Test03").getClassLoader();
        System.out.println("classLoader = " + classLoader);

        String property = System.getProperty("java.class.path");
        System.out.println("property = " + property);

    }
}
