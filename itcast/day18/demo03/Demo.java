package itcast.day18.demo03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> new RunnableImpl());
        executorService.shutdown();
    }
}
