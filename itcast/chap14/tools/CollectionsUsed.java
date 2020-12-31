package itcast.chap14.tools;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsUsed {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 原来的写法
        list.add(12);
        list.add(14);
        list.add(15);
        list.add(1000);

        System.out.println(list);

        Collections.addAll(list, 143, 15, 42);
        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);
    }
}
