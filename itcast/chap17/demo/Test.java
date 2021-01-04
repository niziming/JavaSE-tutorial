package itcast.chap17.demo;

public class Test implements Runnable {
    static Object o = new Object();
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        // try {
        //     o.wait();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }

    public static void main(String[] args) {
        Test test = new Test();
        Thread t = new Thread(test, "hello");
        t.start();
    }
}
