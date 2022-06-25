package chap17.demo4;

public class Ticket implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (ticket > 0) {
            String name = Thread.currentThread().getName();
            // 模拟出票时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "正在卖: " + ticket--);
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
