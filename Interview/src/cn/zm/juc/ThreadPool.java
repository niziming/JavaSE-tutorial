package cn.zm.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Date;
import java.util.concurrent.*;

//region 线程池
// 实现 Runnable 接口和 Callable 接口的区别
// Runnable 接口 不会返回结果或抛出检查异常
// Callable 接口 可以
// 执行 execute() 方法和 submit(      AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(10);别是什么呢？
// 1.execute()方法用于提交不需要返回值的任务，所以无法判断任务是否被线程池执行成功与否；
// 2.submit()方法用于提交需要返回值的任务。线程池会返回一个 Future 类型的对象，通过这个
//Future 对象可以判断任务是否执行成功，并且可以通过 Future 的 get()方法来获取返回值，
// get()方法会阻塞当前线程直到任务完成，
// 而使用 get(long timeout，TimeUnit unit)方法则会阻塞当前线程一段时间后立即返回，
// 这时候有可能任务没有执行完。
public class ThreadPool {
  //region Executors
  // 阿里巴巴 Java 开发手册》中强制线程池不允许使用 Executors 去创建，
  // Executors 返回线程池对象的弊端如下：
  // FixedThreadPool 和 SingleThreadExecutor ：
  // 允许请求的队列长度为 Integer.MAX_VALUE ，可能堆积大量的请求，
  // 从而导致 OOM。
  // CachedThreadPool 和 ScheduledThreadPool ：
  // 允许创建的线程数量为 Integer.MAX_VALUE ，可能会创建大量线程，从而导致 OOM。
  public static class ExecutorsExample {
    public static void main(String[] args) {
      // 该方法返回一个固定线程数量的线程池。该线程池中的线程数量始终不变。
      // 当有一个新的任务提交时，线程池中若有空闲线程，则立即执行。若没有，
      // 则新的任务会被暂存在一个任务队列中，待有线程空闲时，便处理在任务队列中的任务。
      ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
      // 方法返回一个只有一个线程的线程池。若多余一个任务被提交到该线程池，
      // 任务会被保存在一个任务队列中, 待线程空闲，按先入先出的顺序执行队列中的任务。
      ExecutorService singleThread = Executors.newSingleThreadExecutor();
      // 该方法返回一个可根据实际情况调整线程数量的线程池。
      // 线程池的线程数量不确定，但若有空闲线程可以复用，则会优先使用可复用的线程。
      // 若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。
      // 所有线程在当前任务执行完毕后，将返回线程池进行复用。
      ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    }
  }
  //endregion

  //region ThreadPoolExecutor
  // corePoolSize : 核心线程数定义了最小可以同时运行的线程数量。
  private static final int CORE_POOL_SIZE = 5;
  // maximumPoolSize : 当队列中存放的任务达到队列容量的时候，
  // 当前可以同时运行的线程数量变为最大线程数。
  private static final int MAX_POOL_SIZE = 10;
  // workQueue: 当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，
  // 如果达到的话，新任务就会被存放在队列中。
  private static final int QUEUE_CAPACITY = 100;
  // 当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，
  // 核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
  private static final Long KEEP_ALIVE_TIME = 1L;

  private volatile static ThreadPoolExecutor threadPoolExecutor = null;

  private static String threadNamePrefix = "线程名";

  //region getThreadPool
  public static ThreadPoolExecutor getThreadPool() {
    if (threadPoolExecutor == null) {
      synchronized (ThreadPool.class) {
        threadPoolExecutor = new ThreadPoolExecutor(
          CORE_POOL_SIZE,
          MAX_POOL_SIZE,
          KEEP_ALIVE_TIME,
          TimeUnit.SECONDS,
          new ArrayBlockingQueue<>(QUEUE_CAPACITY),
          // new ThreadPoolExecutor.CallerRunsPolicy(),
          new ThreadFactoryBuilder()
            .setNameFormat(threadNamePrefix + "-%d")
            .setDaemon(true).build()
        );
      }
    }
    return threadPoolExecutor;
  }

  public static void main(String[] args) {
    ThreadPoolExecutor threadPool = ThreadPool.getThreadPool();
    for (int i = 0; i < 10; i++) {
      threadPool.execute(new Task("" + i));
    }

    threadPool.shutdown();
    while (!threadPool.isTerminated()) {
    }
    System.out.println("结束");
  }

  public static class Task implements Runnable {
    private String command;

    public Task(String command) {
      this.command = command;
    }

    @Override
    public void run() {
      System.out.println(Thread.currentThread().getName() + "开始时间" + new Date());
      processCommand();
      System.out.println(Thread.currentThread().getName() + "开始时间" + new Date());
    }

    private void processCommand() {
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    @Override
    public String toString() {
      return "ThreadPoolExecutorExample{" +
        "command='" + command + '\'' +
        '}';
    }

  }
//endregion
}
// endregion