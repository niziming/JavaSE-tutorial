package cn.zm.juc;

import java.util.concurrent.*;

//region monitor ThreadPool
public class MonitorThreadPool {
  public static void main(String[] args) {
    ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1, Executors.defaultThreadFactory());
    ThreadPoolExecutor threadPool = ThreadPool.ThreadPoolExecutorExample.getThreadPool();
    service.scheduleAtFixedRate(() -> {
      System.out.println("=========================");
      System.out.println("ThreadPool Size: [{}]" + threadPool.getPoolSize());
      System.out.println("Active Threads: {}" + threadPool.getActiveCount());
      System.out.println("Number of Tasks : {}" + threadPool.getCompletedTaskCount());
      System.out.println("Number of Tasks in Queue: {}" + threadPool.getQueue().size());
      System.out.println("=========================");
    }, 0, 1, TimeUnit.SECONDS);
    for (int i = 0; i < 10; i++) {
      int index = i;
      threadPool.execute(() -> {
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("线程提交" + index);
      });
    }

  }

}
//endregion