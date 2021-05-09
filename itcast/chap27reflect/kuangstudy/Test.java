package itcast.chap27reflect.kuangstudy;

public class Test {
    public static void main(String[] args) {
        Class<Object> objectClass = Object.class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<String[]> aClass = String[].class;
        Class<int[][]> aClass1 = int[][].class;
        Class<Class> classClass = Class.class;
        Class<Override> overrideClass = Override.class;
        System.out.println("objectClass = " + objectClass);
        System.out.println("comparableClass = " + comparableClass);
        System.out.println("aClass = " + aClass);
        System.out.println("int = " + aClass1);
        System.out.println("classClass = " + classClass);
        System.out.println("overrideClass = " + overrideClass);
    }
}
