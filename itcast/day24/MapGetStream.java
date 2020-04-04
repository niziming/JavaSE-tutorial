package itcast.day24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/*
根据Map获取流
 */
public class MapGetStream {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        HashMap<String, String> map= new HashMap<>();
        Stream<String> stream = map.keySet().stream();
        Stream<String> stream1 = map.values().stream();
        Stream<Map.Entry<String, String>> stream2 = map.entrySet().stream();
        stream2.forEach(System.out::print);
    }
}
