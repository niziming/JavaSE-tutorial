package itcast.chap23.demo1;

// 函数式接口 函数式接口在Java中是指：有且仅有一个抽象方法的接口。
@FunctionalInterface
public interface MyFI {
    void method ();
    // void method1();

    public static void doSometing (MyFI myFI) {
        myFI.method();
    }

    public static void main(String[] args) {
        doSometing(() -> System.out.println("hello"));
    }
}
