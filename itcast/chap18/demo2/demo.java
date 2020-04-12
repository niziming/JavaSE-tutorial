package itcast.day18.demo2;

public class demo {
    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " 执行了健身"), "健身教练").start();
    }
}
