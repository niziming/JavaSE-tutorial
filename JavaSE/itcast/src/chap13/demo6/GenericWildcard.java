package chap13.demo6;

import java.util.*;

public class GenericWildcard {
    public static void main(String[] args) {
        // String[] s = new String[]{"hello"};
        // List<String> strings = Arrays.asList(s);
        // getElement(strings);
    }
    //？代表可以接收任意类型
    public static void getElement(Collection<?> coll) {
        // 泛型的上限 此时的 ? 为collection的子类
        Class<? extends Collection> aClass = coll.getClass();
        System.out.println(aClass);
        Iterator<?> iterator = coll.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
    public static void getElement1(Collection<? extends Number> coll){}
    // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
    public static void getElement2(Collection<? super Number> coll){}
}
