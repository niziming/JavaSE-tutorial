package itcast.chap02;

public class Main {
    public static void main(String[] args) {
        float a = 1.6125220F;
        System.out.println((int) a);
        System.out.println('a');
        System.out.println(('a' + 1) % 2);
        if (true) {
            System.out.println("nihao");
        }
        method();
        operator();
        method1();
        // 方法不可嵌套方法
        // public static void method2(){
        // }
    }

    public static void method() {
        System.out.println("我是一个方法");
    }

    public static void operator() {
        int i = 0;
        i = (i == 2 ? 100 : 200);
        System.out.println(i);
        int j = 0;
        j = (3 <= 4 ? 500 : 600);
        System.out.println(j);
    }
    // 方法的调用

    public static String method1() {
        System.out.println("自己定义的方法,需要调用");
        return "11";
    }
}
