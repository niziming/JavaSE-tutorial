package chap18.demo1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "执行完毕");
    }

    // 线程池实例
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        MyRunnable mr = new MyRunnable();

        // 实例化调用
        new Thread(mr).start();

        // 线程池调用
        service.submit(mr);
        service.submit(mr);
        service.submit(mr);
        service.submit(mr);
        service.submit(mr);
        //注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。
        //将使用完的线程又归还到了线程池中
        //关闭线程池
        service.shutdown();

    }
}
