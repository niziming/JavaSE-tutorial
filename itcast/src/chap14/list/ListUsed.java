package chap14.list;

import java.util.ArrayList;
import java.util.List;

public class ListUsed {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        System.out.println(list.getClass());
        System.out.println(list.get(0));

        list.remove(0);
        System.out.println(list);

        list.set(0, "hello");
        System.out.println(list);
    }
}
