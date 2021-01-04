package itcast.chap17.demo2;

public class MyRunable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();
        MyThread mythread = new MyThread("mythread");
        mythread.start();
        myRunable.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        Thread thread = new Thread(myRunable, "hello");

        thread.start();
    }
}
