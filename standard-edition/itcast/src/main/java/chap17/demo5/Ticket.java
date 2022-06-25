package chap17.demo5;

// 同步代码块
public class Ticket implements Runnable {
    private int ticket = 30;
    // 对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁.
    // 1. 锁对象 可以是任意类型。
    // 2. 多个线程对象 要使用同一把锁。
    // 注意:在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程只能在外等着
    //   (BLOCKED)。
    Object lock = new Object();
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        // while (ticket > 0) {
        while (true) {
            synchronized (lock) {
                if (ticket > 0) {
                    // 模拟出票时间
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + "正在卖: " + ticket--);
                } else {
                    System.out.println(name + "执行结束!");
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        // 创建任务
        Ticket ticket = new Ticket();
        // 三个窗口
        Thread win1 = new Thread(ticket, "窗口1");
        Thread win2 = new Thread(ticket, "窗口2");
        Thread win3 = new Thread(ticket, "窗口3");
        // 同时卖票
        win1.start();
        win2.start();
        win3.start();
    }
}
