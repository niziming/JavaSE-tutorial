package itcast.chap17.demo3;

public class NonameInnerClass {
    public static void main(String[] args) {
        new Runnable() {
            public void run () {
                System.out.println(1);
            }
        }.run();
        Runnable r = new Runnable() {
            public void run () {
                System.out.println(Thread.currentThread().getName() + 1);
            }
        };
        new Thread(r, "hello ").start();
        System.out.println("world");
    }
}
