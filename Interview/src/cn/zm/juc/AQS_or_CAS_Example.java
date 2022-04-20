package cn.zm.juc;

import sun.misc.Unsafe;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

//region AQS & CAS
public class AQS_or_CAS_Example {
  //region cas
  public static void cas() {
    // CAS 的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。
    // UnSafe 类的 objectFieldOffset() 方法是一个本地方法，
    // 这个方法是用来拿到“原来的值”的内存地址，返回值是 valueOffset。
    // 另外 value 是一个 volatile 变量，在内存中可见，
    // 因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。
    Unsafe.getUnsafe().compareAndSwapInt(new Object(), 0, 0, 1);
  }
  //endregion

  //region AQS
  // AQS 核心思想是，如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，
  // 并且将共享资源设置为锁定状态。如果被请求的共享资源被占用，
  // 那么就需要一套线程阻塞等待以及被唤醒时锁分配的机制，这个机制 AQS 是用 CLH 队列锁实现的，
  // 即将暂时获取不到锁的线程加入到队列中

  /**
   * AQS 组件总结
   * Semaphore(信号量)-允许多个线程同时访问： synchronized 和 ReentrantLock 都是一次只允许一个线程访问某个资源，Semaphore(信号量)可以指定多个线程同时访问某个资源。
   * CountDownLatch （倒计时器）： CountDownLatch 是一个同步工具类，用来协调多个线程之间的同步。这个工具通常用来控制线程等待，它可以让某一个线程等待直到倒计时结束，再开始执行。
   * CyclicBarrier(循环栅栏)： CyclicBarrier 和 CountDownLatch 非常类似，它也可以实现线程间的技术等待，但是它的功能比 CountDownLatch 更加复杂和强大。主要应用场景和 CountDownLatch 类似。CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。CyclicBarrier 默认的构造方法是 CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程调用 await() 方法告诉 CyclicBarrier 我已经到达了屏障，然后当前线程被阻塞。
   */

  //region CountDownLatch(倒计时器)
  //  用过 CountDownLatch 么？什么场景下用的？
  // CountDownLatch 的作用就是 允许 count 个线程阻塞在一个地方，直至所有线程的任务都执行完毕。之前在项目中，有一个使用多线程读取多个文件处理的场景，我用到了 CountDownLatch 。具体场景是下面这样的：
  //
  // 我们要读取处理 6 个文件，这 6 个任务都是没有执行顺序依赖的任务，但是我们需要返回给用户的时候将这几个文件的处理的结果进行统计整理。
  //
  // 为此我们定义了一个线程池和 count 为 6 的CountDownLatch对象 。使用线程池处理读取任务，每一个线程处理完之后就将 count-1，调用CountDownLatch对象的 await()方法，直到所有文件读取完之后，才会接着执行后面的逻辑。
  //
  // 代码是下面这样的：
  public static class CountDownLatchExample {
    static final int THREAD_COUNT = 6;
    // 前面使用的线程池
    static ThreadPoolExecutor threadPool = ThreadPool.ThreadPoolExecutorExample.getThreadPool();

    /**
     * Used
     */
    public static void countDownLatchUsed() {
      final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);

      for (int i = 0; i < THREAD_COUNT; i++) {
        final int THREAD_NUM = i;
        threadPool.execute(() -> {
          try {
            System.out.println(THREAD_NUM + Thread.currentThread().getName() + "-文件处理完成 ");
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            countDownLatch.countDown();
          }
        });
      }

      try {
        countDownLatch.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      threadPool.shutdown();
      System.out.println("完成");

    }

    /**
     * used 改进
     * <p>
     * 有没有可以改进的地方呢？
     * 可以使用 CompletableFuture 类来改进！Java8 的 CompletableFuture
     * 提供了很多对多线程友好的方法，使用它可以很方便地为我们编写多线程程序，
     * 什么异步、串行、并行或者等待所有线程执行完任务什么的都非常方便。
     */
    public static void completableFutureUsed() {
      CompletableFuture[] tasks = new CompletableFuture[THREAD_COUNT];

      for (int i = 0; i < THREAD_COUNT; i++) {
        final int THREAD_NUM = i;
        CompletableFuture<String> task = CompletableFuture.supplyAsync(() ->
          {
            System.out.println("任务" + THREAD_NUM);
            return "null";
          }
        );
        tasks[i] = task;
      }

      CompletableFuture<Void> headerFuture = CompletableFuture.allOf(tasks);

      try {
        headerFuture.join();
      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.println("全部处理完成");
    }


    /**
     * completableFutureUsed
     * <p>
     * 有没有可以改进的地方呢？
     * 可以使用 CompletableFuture 类来改进！Java8 的 CompletableFuture
     * 提供了很多对多线程友好的方法，使用它可以很方便地为我们编写多线程程序，
     * 什么异步、串行、并行或者等待所有线程执行完任务什么的都非常方便。
     */
    public static void completableFutureUsed1() {
      CompletableFuture<Integer> task = CompletableFuture.supplyAsync(() -> 1);
      task.thenApplyAsync(re -> {
        System.out.println(re);
        return re + 1;
      }).thenApplyAsync(re -> {
        System.out.println(re);
        return re + 1;
      });


    }


    /**
     * used 改进2
     * <p>
     * 上面的代码还可以继续优化，当任务过多的时候，
     * 把每一个 task 都列出来不太现实，可以考虑通过循环来添加任务。
     */
    public static void listCompletableFuture() {
      List<String> paths = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

      List<CompletableFuture<Object>> collect = paths.stream().map(path -> CompletableFuture.supplyAsync(() -> {
        System.out.println(path + "文件正在处理");
        return null;
      })).collect(Collectors.toList());

      CompletableFuture<Void> allFutures = CompletableFuture.allOf(collect.toArray(new CompletableFuture[collect.size()]));

      try {
        allFutures.join();
      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.println("all down");
    }

    public static void main(String[] args) throws InterruptedException {
      // listCompletableFuture();
      // completableFutureUsed();
      completableFutureUsed1();
      // countDownLatchUsed();

    }

  }
  //endregion

  // region Semaphore(信号量)
  // * Semaphore(信号量)-允许多个线程同时访问：
  // synchronized 和 ReentrantLock 都是一次只允许一个线程访问某个资源，
  // Semaphore(信号量)可以指定多个线程同时访问某个资源。
  public static class SemaphoreExample {
    // 请求数量
    private static final int THREAD_COUNT = 550;

    private Lock lock = new ReentrantLock();


    public static void main(String[] args) {
      // 获取线程池创建一个固定数量的线程池
      ExecutorService pool = Executors.newFixedThreadPool(300);

      // 一次允许执行的线程池数量
      final Semaphore semaphore = new Semaphore(20); // 非公平
      // final Semaphore semaphore = new Semaphore(20, true); // 公平
      SemaphoreExample semaphoreExample = new SemaphoreExample();
      for (int i = 0; i < THREAD_COUNT; i++) {
        final int THREAD_NUM = i;
        pool.execute(() -> {
          try {
            semaphore.acquire(5); // 获取一个许可 所以可运行线程数量为20/5=4;
            // SemaphoreExample.class.wait(2000);
            semaphoreExample.test(THREAD_NUM);
            semaphore.release(5); // 释放
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
      }
      pool.shutdown();
      System.out.println("finish");
    }

    private void test(int thread_num) throws InterruptedException {
      // lock.lock();
      try {
        Thread.sleep(2000);
        System.out.println("thread_num = " + thread_num);
        Thread.sleep(2000);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        // lock.unlock();
      }
    }

  }
  //endregion

  //region CyclicBarrier(循环栅栏)
  // CyclicBarrier 和 CountDownLatch 非常类似，它也可以实现线程间的技术等待，但是它的功能比 CountDownLatch 更加复杂和强大。主要应用场景和 CountDownLatch 类似。
  // CountDownLatch 的实现是基于 AQS 的，而 CycliBarrier 是基于 ReentrantLock(ReentrantLock 也属于 AQS 同步器)和 Condition 的。
  public static class CyclicBarrierExample {
    // 请求数
    private static final int THREAD_COUNT = 20;

    // 需要同步现场的数量
    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    // 优先执行 barrierAction
    public static final CyclicBarrier cyclicBarrier1 = new CyclicBarrier(5, () -> {
      System.out.println("------当线程数达到之后，优先执行------");
    });

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, TimeoutException {
      test1();
      // test();
    }

    /**
     * CyclicBarrier 还提供一个更高级的构造函数
     * CyclicBarrier(int parties, Runnable barrierAction)，用于在线程到达屏障时，
     * 优先执行 barrierAction，方便处理更复杂的业务场景。
     */
    private static void test1() {
      ExecutorService threadPool = Executors.newFixedThreadPool(10);
      for (int i = 0; i < THREAD_COUNT; i++) {
        int THREAD_NUM = i;
        threadPool.execute(() -> {
          try {
            System.out.println("THREAD_NUM = " + THREAD_NUM + "is ready");
            cyclicBarrier1.await();
            System.out.println("THREAD_NUM = " + THREAD_NUM + "is finish");
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (BrokenBarrierException e) {
            e.printStackTrace();
          }
        });
      }
      threadPool.shutdown();
    }

    /**
     * CyclicBarrier 可以用于多线程计算数据，最后合并计算结果的应用场景。
     *
     * @throws InterruptedException
     * @throws BrokenBarrierException
     */
    private static void test() throws InterruptedException, BrokenBarrierException {
      ExecutorService threadPool = Executors.newFixedThreadPool(10);

      for (int i = 0; i < THREAD_COUNT; i++) {
        final int THREAD_NUM = i;
        Thread.sleep(1000);
        threadPool.execute(() -> {
          System.out.println("thread_num = " + THREAD_NUM + "is ready");
          // 等待60秒, 保证子线程完全执行结束
          try {
            cyclicBarrier.await(60, TimeUnit.SECONDS);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (BrokenBarrierException e) {
            e.printStackTrace();
          } catch (TimeoutException e) {
            e.printStackTrace();
          }
          System.out.println("thread_num = " + THREAD_NUM + "is finish");
        });
      }

      threadPool.shutdown();

    }
  }
  //endregion

  //endregion

}
//endregion
