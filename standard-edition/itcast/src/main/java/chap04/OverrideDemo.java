package chap04;

public class OverrideDemo {
    public static void main(String[] args) {
        //定义不同数据类型的变量
        byte a = 10;
        byte b = 20;
        short c = 10;
        short d = 20;
        int e = 10;
        int f = 10;
        long g = 10;
        long h = 20;
        System.out.println(compareDemo(a, b));
        System.out.println(compareDemo(c, d));
        System.out.println(compareDemo(e, f));
        System.out.println(compareDemo(g, h));
    }

    private static boolean compareDemo(long g, long h) {
        return g == h;
    }

    private static boolean compareDemo(int e, int f) {
        return e == f;
    }

    private static boolean compareDemo(short c, short d) {
        return c == d;
    }

    private static boolean compareDemo(byte a, byte b) {
        return a == b;
    }
}
