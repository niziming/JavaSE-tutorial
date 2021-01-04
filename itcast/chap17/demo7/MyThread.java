package itcast.chap17.demo7;

public class MyThread extends Thread {
    MyThread (String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(getName() + "开始");
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.println("--------" + i);
            }
            System.out.println(i);
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getState() + "线程睡眠1秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyThread("ceshi").start();
    }
}
