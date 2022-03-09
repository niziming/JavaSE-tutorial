package chap23.demo4;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
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

    // andThen(然后)接口 有时候我们需要对某种类型的数据进行判断，
    // 从而得到一个boolean值结果。这时可以使用
    public static <E> void andThenUsed(Consumer c1, Consumer c2, E e) {
        c1.andThen(c2).accept(e);
    }

    // Predicate(断言)接口 如果一个方法的参数和返回值全都是 Consumer 类型，
    // 那么就可以实现效果：消费数据的时候，首先做一个操作，然后再做一个操作，实现组合。
    public static <T> boolean predicateTest(Predicate p, T t) {
        return p.test(t);
    }

    public static <E> Predicate predicateAnd(Predicate... p) {
        // return p.length == 1 ? p[0] : p[p.length - 1].and(p[p.length - 2]);
       // return p[0].and(p[1]);
        int length = p.length - 1;
        return length == 0 ? p[0] : predicateAnd(rmLast(p)).and(p[length]);
        // return () -> test(t) && other.test(t);
    }

    public static <E> E[] rmLast (E[] e) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < e.length - 2; i++) {
            list.add(e[i]);
        }
        return (E[]) list.clone();
        // return clone;
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


        // predicate
        // test
        boolean b = predicateTest(e -> e.toString().length() > 5, "我很长吗????");
        System.out.println(b);
        // // predicate and
        // Predicate predicate = predicateAnd(
        //         e -> e.toString().startsWith("hello"),
        //         e -> e.toString().endsWith("world")
        // );
        // boolean p1 = predicate.test("nihao");
        // boolean p2 = predicate.test("hello world");
        //
        // System.out.println(p1);
        // System.out.println(p2);
        // System.out.println(rmLast(new Integer[]{1, 2}));

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        System.out.println(list);
        Object clone = list.clone();
        System.out.println(clone);

    }
}
