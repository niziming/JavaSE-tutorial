package day03;

public class Do02While {
    public static void main(String[] args) {
        // print();
        // int count = count(7, 8);
        // count(0, 100);
        char[] chars = "helloword".toCharArray();
        System.out.println(chars[0]);
    }
    private static void print () {
        int i = 0;
        do {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
            ++i;
        } while ( i!=10 );
    }
    public static int count (int a, int b, int c) {
        System.out.println(a+b);
        return a+b;
    }
    public static boolean equals (int a, int b) {
        boolean b1 = a == b;
        if (b1) {
            System.out.println("相等");
        } else {
            System.out.println("不相等");
        }
        return b1;
    }
    public static int count (int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += i;
        }
        System.out.println(count);
        return count;
    }
}
