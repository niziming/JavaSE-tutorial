package itcast.chap15.demo3;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapUsed {
    public static void main(String[] args) {
        Set<String> a = Set.of("a", "b", "c");
        System.out.println(a);

        Set<? extends Serializable> e = Set.of("e", "f", 1);
        System.out.println(e);

        Map<String, Integer> a1 = Map.of("a", 1, "b", 2, "c", 3);
        System.out.println(a1);

        List<String> e1 = List.of("e", "f");
        System.out.println(e1);

    }
}
