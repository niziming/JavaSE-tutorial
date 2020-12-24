package itcast.chap11.demo6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
当接口作为方法的参数时,需要传递什么呢？当接口作为方法的返回值类型时，需要返回什么呢？对，其实都是它的
子类对象。 ArrayList 类我们并不陌生，查看API我们发现，实际上，它是 java.util.List 接口的实现类。所
以，当我们看见 List 接口作为参数或者返回值类型时，当然可以将 ArrayList 的对象进行传递或返回。
 */
public class Test {
    public static void main(String[] args) {
        // 创建ArrayList集合,并添加数字
        ArrayList<Integer> srcList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            srcList.add(i);
        }
        System.out.println(getEvenNum(srcList));
    }

    private static List<Integer> getEvenNum(List<Integer> list) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer integer : list) {
            if (integer != 0 && integer % 2 == 0)integers.add(integer);
        }
        return integers;
    }
}
