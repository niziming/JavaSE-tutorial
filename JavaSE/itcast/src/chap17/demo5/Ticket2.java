package chap17.demo5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 同步方法
// Lock 锁
public class Ticket2 implements Runnable{
    private int ticket = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            sellTicket();
            lock.unlock();
        }
    }

    private void sellTicket() {
        String name = Thread.currentThread().getName();
        if (ticket > 0) {
            //有票 可以卖
            //出票操作
            //使用sleep模拟一下出票时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "卖出" + ticket--);
        }
    }

    public static void main(String[] args) {
        Ticket2 ticket1 = new Ticket2();
        Thread win1 = new Thread(ticket1, "窗口1");
        Thread win2 = new Thread(ticket1, "窗口2");
        Thread win3 = new Thread(ticket1, "窗口3");
        win1.start();
        win2.start();
        win3.start();
    }
}
