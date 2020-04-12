package itcast.day14;

import java.util.*;

public class CollDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet hashSet = new HashSet();
        Set lhs = new LinkedHashSet();
        Collections.addAll(list, 5,1,2,2,2,4,56,23);
        Collections.addAll(hashSet, 5,1,2,2,2,4,56,23);
        Collections.addAll(lhs, 5,1,2,2,2,4,56,23);
        System.out.println(list);
        System.out.println(hashSet);
        System.out.println(lhs);
        Collections.sort(list);
        System.out.println("+++++++++++++++++++++++");
        System.out.println(list);
    }
}
