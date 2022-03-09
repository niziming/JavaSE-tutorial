package chap24;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethod {
    public static void main(String[] args) {
        // forEachMethod();
        // filterMethod();
        // getStream().forEach(StreamMethod::addString);
        mapMethod();
        // countMethod();
        // limitMethod();
        // skipMethod();
        // concatMethod();
    }

    private static void concatMethod() {
        Stream<String> stream = getStream();
        Stream<String> stream1 = getStream();
        Stream<String> concat = Stream.concat(stream, stream1);
        // concat.forEach(System.out::print);
        concat.forEach(s -> System.out.print(" " + s));
    }

    private static void skipMethod() {
        Stream<String> stream = getStream();
        Stream<String> skip = stream.skip(2);
        System.out.println(skip.count());
    }

    private static void limitMethod() {
        Stream<String> limit = getStream().limit(2);
        limit.forEach(s -> System.out.println(s));
        // System.out.println("取用前几个：limit " + limit.count());
    }

    /**
     * 统计个数：count
     * 正如旧集合Collection当中的size方法一样，流提供count方法来数一数其中的元素个数
     */
    private static void countMethod() {
        long count = getStream().count();
        System.out.println("count: " + count);
    }

    /**
     * 如果需要将流中的元素映射到另一个流中，可以使用map方法.
     */
    private static void mapMethod() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        Stream<String> stream = Stream.of("11", "12", "3");
        // Stream<Integer> integer = stream.map(s -> Integer.parseInt(s));
        List<Integer> collect = stream.map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        // System.out.println("---------" + arrayList);
        // integer.forEach(System.out::println);
        System.out.println(collect);
    }

    /**
     * 流模型的操作很丰富，这里介绍一些常用的API。这些方法可以被分成两种：
     * 延迟方法：返回值类型仍然是Stream接口自身类型的方法，因此支持链式调用。（除了终结方法外，其余方法均为延迟方法。）
     * 终结方法：返回值类型不再是Stream接口自身类型的方法，因此不再支持类似StringBuilder那样的链式调用。本小节中，终结方法包括count和forEach方法。
     */
    public static Stream<String> getStream(){
        return Stream.of(new String[]{"张无忌", "张三丰", "周芷若"});
    }
    public static void forEachMethod() {
        Stream<String> stream = getStream();
        ArrayList<String> strings = new ArrayList<>();
        stream.forEach(s -> strings.add(s));
        System.out.println(strings);
    }
    public static void filterMethod(){
        Stream<String> stream = getStream();
        stream.filter(s -> s.startsWith("张")).forEach(System.out::print);
    }
    public static void addString(String x){
        System.out.println(x + "add");
    }
}
