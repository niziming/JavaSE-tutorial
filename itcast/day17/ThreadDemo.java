package itcast.day17;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread("小强");
        MyThread thread1 = new MyThread("刘欢");
        thread.start(); // 开启一个新的线程
        thread1.start(); // 开启一个新的线程
        // String name = thread.getName();
        // Thread thread1 = thread.currentThread();
        // System.out.println(name);
        // System.out.println(thread1);
        // long l2 = System.currentTimeMillis();
        // for (int i = 0; i < 20; i++) {
        //     System.out.println("旺财: " + i);
        // }
        // long l3 = System.currentTimeMillis() - l2;
        // System.out.println(l3);
    }
}
