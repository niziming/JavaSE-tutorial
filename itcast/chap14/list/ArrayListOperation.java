package itcast.chap14.list;

import java.util.ArrayList;

public class ArrayListOperation {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("nihao1");
        list.add("nihao2");
        list.add("nihao3");
        list.add(3, "nihao4");
        list.add(0, "1");
        list.add(4, "nihao5");
        System.out.println(list);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list);
        Object sanmao = list.set(0, "sanmao");
        System.out.println(list);
        System.out.println(sanmao);
    }
}
