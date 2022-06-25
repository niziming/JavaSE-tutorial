package chap24stream;

import java.util.*;
import java.util.stream.Stream;

public class CollectionGetStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Set<String> set= new HashSet<>();
        Stream<String> stream1 = set.stream();
        Vector<String> vector = new Vector<>();
        Stream<String> stream2 = vector.stream();

    }

    public static void method() {

    }

}
