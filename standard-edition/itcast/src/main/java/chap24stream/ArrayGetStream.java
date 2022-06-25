package chap24stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayGetStream {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        String[] array= { "张无忌", "张翠山", "张三丰", "张一元", "王老五" };
        Stream<String> array1 = Stream.of(array);
        array1.filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
        System.out.println(Arrays.toString(array));
    }

}
