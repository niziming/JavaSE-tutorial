package itcast.chap04;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        boolean compare = compare(2, 2);
        System.out.println(compare);
    }

    private static boolean compare(int i, int i1) {
        return i == i1;
    }
}
