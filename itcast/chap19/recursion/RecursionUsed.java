package itcast.chap19.recursion;

public class RecursionUsed {
    public static void main(String[] args) {
        b(10);
        int count = count(100);
        int count1 = count1(3);
        System.out.println(count);
        System.out.println(count1);
    }

    // 1 到 N的累加
    private static int count(int i) {
        return i == 0 ? 0 : count(i - 1) + i;
    }
    // 1 到 N的阶乘
    private static int count1(int i) {
        return i == 1 ? 1 : count(i - 1) * i;
    }

    public static void b (int i) {
        System.out.println(i);
        if (i == 100) {
            return;
        }
        b(++i);
    }
}
