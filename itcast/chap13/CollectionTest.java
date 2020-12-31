package itcast.chap13;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
    }

    public static void testForEach() {
        int[] arr = {0, 1, 2, 3, 4};
        for (int a : arr) {
            System.out.println(a);
        }
        Collection coll = new ArrayList();
        coll.add("asdasdfasd");
        coll.add("asdasdfasd");
        // Iterator<String> iterator = coll.iterator();
        // boolean b = iterator.hasNext();
        // if (b) {
        //     String next = iterator.next();
        //     System.out.println();
        // }
        Object o = ((ArrayList) coll).get(1);
        System.out.println(o);
        // for (Object s : coll) {
        //     System.out.println(s);
        // }
    }

    private static void testIterable() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("串串");
        strings.add("吐槽");
        strings.add("汪星人");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
    }

    private static void testContains() {
        Collection<String> strings = testDemo();
        strings.remove("扫地僧");
        System.out.println(strings);
        System.out.println(strings.size());
    }

    public static Collection<String> testDemo() {
        Collection<String> coll = new ArrayList<String>();
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        System.out.println(coll);
        return coll;
    }

    public static void testMethod() {
        ArrayList a = new ArrayList();
        System.out.println(a.isEmpty());
        System.out.println(a.size());
    }
}
