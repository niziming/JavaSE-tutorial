package liangyong.capture30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        // 创建一个最大线程数为3的线程池
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 以下三个任务将按照顺序执行,因为线程池只有一个线程
        // ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 将每个等待的任务创建一个新线程,所以所以任务会并发执行
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 提交可运行的任务给executor
        executorService.execute(new PrintChar('a', 100));
        executorService.execute(new PrintChar('b', 100));
        executorService.execute(new PrintNum(100));

        // 关闭执行器, 通知执行器关闭,不能接受新任务,但是现有的任务将继续执行至完成.
        executorService.shutdown();
    }
}
