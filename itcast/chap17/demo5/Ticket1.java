package itcast.chap17.demo5;

// 同步方法
public class Ticket1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (ticket != 0) {
            sellTicket();
        }
    }

    private synchronized void sellTicket() {
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
        Ticket1 ticket1 = new Ticket1();
        Thread win1 = new Thread(ticket1, "窗口1");
        Thread win2 = new Thread(ticket1, "窗口2");
        Thread win3 = new Thread(ticket1, "窗口3");
        win1.start();
        win2.start();
        win3.start();
    }
}
