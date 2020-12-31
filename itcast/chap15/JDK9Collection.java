package itcast.chap15;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JDK9Collection {
    public static void main(String[] args) {
        Set<Integer> num = Set.of(1, 2, 3, 4, 5);
        System.out.println(num);
        // num.add(5); // 这里编译的时候不会错，但是执行的时候会报错，因为是不可变的集合
        Map<String, String> hello = Map.of("hello", "你好", "world", "世界");
        System.out.println(hello);
        Integer[] a = {1,2,3};
        List<Integer> a1 = List.of(a);
        System.out.println(a1);
    }
}
