package cn.zm.juc.c001_volatile;

public class T01_HelloVolatile {
    volatile boolean running = true;

    void method () {
        System.out.println("start");
        while (running) {
            System.out.println("hello");
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws InterruptedException {
        T01_HelloVolatile v = new T01_HelloVolatile();
        new Thread(v::method, "t1").start();
        Thread.sleep(1);
        v.running = false;

    }
}
