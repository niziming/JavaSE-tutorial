package itcast.chap23.demo3;

import java.util.Arrays;
import java.util.Comparator;

// 使用Lambda作为参数和返回值
public class LambdaParam {
    // 函数式接口作为入参
    public static void startThread(Runnable task) {
        new Thread(task).start();
    }
    // 函数式接口作为返回值
    public static Comparator<String> newComparator() {
        return (a, b) -> a.length() - b.length();
    }
}
class excute{
    public static void main(String[] args) {
        // 函数式接口作为入参
        LambdaParam.startThread(() -> System.out.println("execute"));
        // 函数式接口作为返回值
        String[] array = { "abc", "ab", "abcd" };
        Arrays.sort(array, LambdaParam.newComparator());
        System.out.println(Arrays.toString(array));
    }
}
