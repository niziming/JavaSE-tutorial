package itcast.day18.demo1;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获得" + Thread.currentThread().getName() + "健身教练");
        System.out.println("开始训练");
    }
}
