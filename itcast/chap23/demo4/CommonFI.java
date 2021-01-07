package itcast.chap23.demo4;

import java.util.function.Consumer;
import java.util.function.Supplier;

// JDK提供了大量常用的函数式接口以丰富Lambda的典型使用场景，它们主要在 java.util.function 包中被提供。
// 下面是最简单的几个接口及使用示例。
public class CommonFI<T> {
    // Supplier(供应商)接口 生产一个数据
    public static Object supplierUsed(Supplier s) {
        return s.get();
    }

    // Consumer(消费者)接口 消费一个数据
    public static <E> void consumerUsed(Consumer c, E e) {
        c.accept(e);
    }

    // andThen(然后)接口 如果一个方法的参数和返回值全都是 Consumer 类型，
    // 那么就可以实现效果：消费数据的时候，首先做一个操作，然后再做一个操作，实现组合。
    public static <E> void andThenUsed(Consumer c1, Consumer c2, E e) {
        c1.andThen(c2).accept(e);
    }

    public static void main(String[] args) {
        // supplier Used
        System.out.println(supplierUsed(() -> "str" + "wro"));
        // 求数组元素最大值
        int[] arr = {2, 3, 4, 52, 333, 23};
        System.out.println(supplierUsed(() -> {
            int max = arr[0];
            for (int i : arr) max = i > max ? i : max;
            return max;
        }));

        // Consumer Used
        consumerUsed(a -> System.out.println(a), "消费者!!");
        // 等同于
        new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        }.accept("消费者!!");

        // andThen Used
        andThenUsed(
                c1 -> {
                    System.out.println("先大写: " + c1.toString().toUpperCase());
                },
                c2 -> {
                    System.out.println("后小写: " + c2.toString().toLowerCase());
                },
                "param");


    }
}
