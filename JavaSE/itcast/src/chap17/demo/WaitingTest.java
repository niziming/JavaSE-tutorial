package chap17.demo;

public class WaitingTest {
    static Object obj = new Object();

    public static void main(String[] args) {
        MyThread myThread = new MyThread("ziming");
        try {
            new Object().wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Thread thread = new Thread();
        // new Thread(thread, "阿萨德");
        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         while (true) {
        //             synchronized (obj){
        //                 try {
        //                     System.out.println(Thread.currentThread().getName()+"===获取到锁对象，调用wait方法，进入waiting状态，释放锁对象");
        //                     obj.wait(5000);
        //                 } catch (InterruptedException e) {
        //                     e.printStackTrace();
        //                 }
        //                 System.out.println(Thread.currentThread().getName()+"===从waiting状态醒来，获取到锁对象，继续执行了");
        //             }
        //         }
        //     }
        // }, "等待线程").start();
        // Thread thread = new Thread();
        // try {
        //     Thread.sleep(100);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // thread.start();
        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         while (true) {
        //             synchronized (obj){
        //                 try {
        //                     System.out.println(Thread.currentThread().getName()+"‐‐‐‐‐等待3秒钟");
        //                     Thread.sleep(5000);
        //                 } catch (InterruptedException e) {
        //                     e.printStackTrace();
        //                 }
        //                 System.out.println(Thread.currentThread().getName()+"‐‐‐‐‐获取到锁对象,调用notify方法，释放锁对象");
        //             }
        //         }
        //     }
        // }, "唤醒线程").start();
    }
}
