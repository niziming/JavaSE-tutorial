package cn.zm.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author DELL
 */
public class LambdaInterfaceExample {
  /**
   * Consumer 消费接口 消费接口，传入一个参数，并对其进行相应的操作（有点类似于lambda表达式）
   */
  public static void consumer() {
    Consumer<String> consumer = new Consumer() {
      @Override
      public void accept(Object o) {
        System.out.println(o);
      }
    };
    Consumer<String> consumer1 = System.out::println;

    Consumer<String> consumer2 = (o) -> System.out.println(o);

    consumer.accept("hello");

    System.out.println("==============");

    Stream<String> listStream = Stream.of("spring", "summer", "autumn", "winter");
    Stream<String> listStream1 = Stream.of("spring", "summer", "autumn", "winter");
    Stream<String> listStream2 = Stream.of("spring", "summer", "autumn", "winter");
    Stream<String> listStream3 = Stream.of("spring", "summer", "autumn", "winter");
    // listStream.forEach(consumer);
    // listStream.forEach(consumer1);
    Consumer<String> consumer3 = consumer2.andThen((o) -> {
      System.out.println("o = " + o);
      final String o1 = o + "-";
      o = o1;
    });
    // listStream.forEach(consumer3);
    // 注：Stream只能用一次，无法reuse，违规则报错，因此在上述测试的时候建立了多个Stream对象；
    System.out.println("listStream = " + listStream.collect(Collectors.joining("-")));
    // listStream1.forEach(System.out::println);
    // listStream2.forEach((o) -> System.out.println("o = " + o));
    //
    // System.out.println("listStream = " + listStream3.collect(Collectors.toList()));

  }

  /**
   * Supplier 供给接口 返回一个参数
   */
  public static void supplier(Supplier sup)  {
    Supplier<String> supplier = () -> "ada";
    System.out.println("supplier.get-" + sup.get());

  }

  /**
   * Function 接收一个参数返回一个结果
   */
  public static void function()  {
    Function<String, Integer> function = str -> Integer.valueOf(str);
    Integer apply = function
      .andThen(s -> s * 10) // andThen
      .compose(x -> x + "10") // 先执行
      .apply("100");
    System.out.println("apply = " + apply);

  }

  /**
   * Predicate 判断参数T是否满足要求,可以理解为 条件A
   */
  public static void predicate()  {
    Predicate<Integer> predicate = t -> t>10;
    Predicate<Integer> predicate1 = t -> t>10;

    Predicate<Integer> or = predicate1.or(t2 -> {
      System.out.println("t2 = " + t2);
      return t2 < 10;
    });


    System.out.println("predicat = " + predicate.test(1));
    System.out.println("predicat = " + predicate1.test(20));
    System.out.println("negate = " + or.or(c -> c < 20).test(20));

  }

  public static void main(String[] args) {
    predicate();
    // function();
    // consumer();
    // supplier(() -> "aaa");
  }
}
