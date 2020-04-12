package itcast.day18.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        MyRunnable r = new MyRunnable();
        // Thread t = new Thread(r, "王涛");
        // t.start();
        service.submit(r);
        service.submit(r);
        service.submit(r);
        // 从线程池中获取线程对象,然后调用MyRunnable中的run()
        service.shutdown();
    }
}
