package chap17.demo7;

import java.util.Objects;

public class WatingTest {
    static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println("获取锁对象调用wait");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("从wait状态中唤醒");
                        return;
                    }
                }
            }
        }, "等待线程").start();

        // try {
        //     Thread.sleep(1000);
        //     synchronized (obj) {
        //         obj.notify();
        //     }
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        new Thread(new Runnable() {
            @Override
            public void run() {
                // while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {
                    obj.notify();
                }
                // }
            }
        }, "唤醒").start();
    }
}
