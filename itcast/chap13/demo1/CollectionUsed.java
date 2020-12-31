package itcast.chap13.demo1;

import java.util.*;

public class CollectionUsed {
    public static void main(String[] args) {
        // Collection<String> coll = new ArrayList<>();
        // coll.add("str1");
        // coll.add("str2");
        // coll.add("str3");
        // System.out.println(coll);
        //
        // Object[] objects = coll.toArray();
        //
        // System.out.println(objects);
        //
        // coll.remove("str1");
        // System.out.println(coll);
        //
        // coll.remove("str2");
        // System.out.println(coll);
        //
        // boolean empty = coll.isEmpty();
        // System.out.println(empty);
        //
        //
        // coll.clear();
        // System.out.println(coll);
        //
        // 使用多态方式 创建对象
        Collection<String> coll1 = new ArrayList<>();

        // 添加元素到集合
        coll1.add("串串星人");
        coll1.add("吐槽星人");
        coll1.add("汪星人");

        Iterator<String> iterator = coll1.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        // 在进行集合元素取出时，如果集合中已经没有元素了，还继续使用迭代器的next方法，将会发生java.util.NoSuchElementException没有集合元素的错误。
        // String next = iterator.next();
        // System.out.println(next);

        int[] arr = {3,5,6,87};
        for (int i : arr) {
            System.out.println(i);
        }

        Set<String> strings = new HashSet<>();
        strings.add("hello");
        strings.add("world");
        System.out.println(strings);
        for (String s : strings) {
            System.out.println(s);
        }



    }
}
