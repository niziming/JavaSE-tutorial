package atguigu.chap12generic.generic;

import java.util.ArrayList;
import java.util.List;
/*
没有使用泛型
 */
public class Demo01 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        List<String> list = new ArrayList<>();
        list.add("avc");
        list.add("100");
        list.forEach(e -> {
            System.out.println(e.getClass());
        });
        System.out.println(list);
    }

    private static void test1() {
        List list = new ArrayList();
        list.add("avc");
        list.add(100);
        list.forEach(e -> {
            System.out.println(e.getClass());
        });
        System.out.println(list);
    }
}
