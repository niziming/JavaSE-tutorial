package itcast.day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> hs = new HashSet();
        Set lhs = new LinkedHashSet();
        lhs.add("bbb");
        lhs.add("aaa");
        lhs.add("abc");
        lhs.add("bbc");
        hs.add("bbb");
        hs.add("aaa");
        hs.add("abc");
        hs.add("bbc");
        Iterator it = lhs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(it);
        System.out.println(lhs);
        Iterator iterator = hs.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
