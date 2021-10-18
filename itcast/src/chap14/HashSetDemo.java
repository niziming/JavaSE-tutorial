package chap14;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet);
        boolean cba = hashSet.add("cba");
        boolean cba1 = hashSet.add("cba");
        hashSet.add("abc");
        hashSet.add("bca");
        hashSet.add("bac");
        hashSet.add("cab");
        System.out.println(hashSet);
        System.out.println(cba);
        System.out.println(cba1);
    }
}
