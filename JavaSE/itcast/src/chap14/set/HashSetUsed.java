package chap14.set;

import java.util.Collection;
import java.util.HashSet;

public class HashSetUsed {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("abc");
        hashSet.add("edf");
        hashSet.add(new String("hij"));
        System.out.println(hashSet);
    }
}
