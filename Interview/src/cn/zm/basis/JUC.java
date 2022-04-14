package cn.zm.basis;

import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class JUC {
  //region AQS & CAS
  public static class AQSExample {
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
    //region CountDownLatch
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
          });


        }



      /**
       * used 改进2
       *
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

    //endregion

  }
  //endregion

  //region Atomic 原子类
  // Atomic 翻译成中文是原子的意思。在化学上，我们知道原子是构成一般物质的最小单位，
  // 在化学反应中是不可分割的。在我们这里 Atomic 是指一个操作是不可中断的。
  // 即使是在多个线程一起执行的时候，一个操作一旦开始，就不会被其他线程干扰。

  // 并发包 java.util.concurrent 的原子类都存放在java.util.concurrent.atomic下,如下图所示。
  public static class AtomicExample {
    //region AtomicInteger Example

    /**
     * AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。
     * CAS 的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。UnSafe 类的 objectFieldOffset() 方法是一个本地方法，这个方法是用来拿到“原来的值”的内存地址，返回值是 valueOffset。另外 value 是一个 volatile 变量，在内存中可见，因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。
     * 关于 Atomic 原子类这部分更多内容可以查看我的这篇文章：并发编程面试必备：JUC 中的 Atomic 原子类总结
     */
    public static class AtomicIntegerExample {
      private AtomicInteger count = new AtomicInteger();

      /**
       * 自增一
       */
      // 使用AtomicInteger之后，不需要对该方法加锁，也可以实现线程安全。
      public int increment() {
        return count.incrementAndGet();
      }

      /**
       * 获取count
       */
      public int getCount() {
        return count.get();
      }

      /**
       * set
       */
      public void set(int o) {
        count.set(o);
      }

      public static void main(String[] args) {

        AtomicIntegerExample atomicIntegerExample = new AtomicIntegerExample();
        for (int i = 0; i < 2220; i++) {
          atomicIntegerExample.increment();
        }
        System.out.println("atomicIntegerExample.getCount() = " + atomicIntegerExample.getCount());

        //region AtomicInteger 常见方法使用
        int temvalue = 0;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        temvalue = atomicInteger.getAndSet(3);
        System.out.println("temvalue = " + temvalue + "; " + atomicInteger);
        temvalue = atomicInteger.getAndIncrement();
        System.out.println("temvalue = " + temvalue + "; " + atomicInteger);
        temvalue = atomicInteger.getAndAdd(5);
        System.out.println("temvalue = " + temvalue + "; " + atomicInteger);
        //endregion

        AtomicIntegerExample e = new AtomicIntegerExample();
        for (int j = 0; j < 1000; j++) {
          e.syncMethod();
        }
        System.out.println(e.getValI());
      }

      /**
       * syncMethod
       */
      static volatile int i = 0;

      public synchronized void syncMethod() {
        i++;
      }

      public int getValI() {
        return i;
      }


    }
    //endregion

    //region JUC 包中的原子类是哪 4 类?
    public static void main(String[] args) {

      // 基本类型
      // 使用原子的方式更新基本类型
      //
      // AtomicInteger：整型原子类
      // AtomicLong：长整型原子类
      // AtomicBoolean：布尔型原子类
      AtomicInteger atomicInteger = new AtomicInteger();
      AtomicLong atomicLong = new AtomicLong();
      AtomicBoolean atomicBoolean = new AtomicBoolean();

      // 数组类型
      //
      // 使用原子的方式更新数组里的某个元素
      //
      // AtomicIntegerArray：整型数组原子类
      // AtomicLongArray：长整型数组原子类
      // AtomicReferenceArray：引用类型数组原子类
      AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
      AtomicLongArray atomicLongArray = new AtomicLongArray(10);

      // 引用类型
      //
      // AtomicReference：引用类型原子类
      // AtomicStampedReference：原子更新带有版本号的引用类型。该类将整数值与引用关联起来，可用于解决原子的更新数据和数据的版本号，可以解决使用 CAS 进行原子更新时可能出现的 ABA 问题。
      // AtomicMarkableReference ：原子更新带有标记位的引用类型
      AtomicReference<Object> objectAtomicReference = new AtomicReference<>();

      //   对象的属性修改类型
      //
      // AtomicIntegerFieldUpdater：原子更新整型字段的更新器
      // AtomicLongFieldUpdater：原子更新长整型字段的更新器
      // AtomicReferenceFieldUpdater：原子更新引用类型字段的更新器

    }
    //endregion

  }
  //endregion

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
  public static class ThreadPool {
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
    public static class ThreadPoolExecutorExample {
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

      //region getThreadPool
      public static ThreadPoolExecutor getThreadPool() {
        if (threadPoolExecutor == null) {
          synchronized (ThreadPoolExecutorExample.class) {
            threadPoolExecutor = new ThreadPoolExecutor(
              CORE_POOL_SIZE,
              MAX_POOL_SIZE,
              KEEP_ALIVE_TIME,
              TimeUnit.SECONDS,
              new ArrayBlockingQueue<>(QUEUE_CAPACITY),
              new ThreadPoolExecutor.CallerRunsPolicy()
            );
          }
        }
        return threadPoolExecutor;
      }
      //endregion

      public static void main(String[] args) {
        ThreadPoolExecutor threadPool = ThreadPoolExecutorExample.getThreadPool();
        for (int i = 0; i < 10; i++) {
          threadPool.execute(new Task("" + i));
        }

        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
        }
        System.out.println("结束");
      }
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

  // region ThreadLocal
  // 通常情况下，我们创建的变量是可以被任何一个线程访问并修改的。
  // 如果想实现每一个线程都有自己的专属本地变量该如何解决呢？
  // JDK 中提供的ThreadLocal类正是为了解决这样的问题。
  // ThreadLocal类主要解决的就是让每个线程绑定自己的值，
  // 可以将ThreadLocal类形象的比喻成存放数据的盒子，
  // 盒子中可以存储每个线程的私有数据。
  public static class ThreadLocalExample implements Runnable {

    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    @Override
    public void run() {
      System.out.println("线程名称 = " + Thread.currentThread().getName() + " 默认格式 = " + formatter.get().toPattern());
      try {
        Thread.sleep(new Random().nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      formatter.set(new SimpleDateFormat());
      System.out.println("线程名称 = " + Thread.currentThread().getName() + " 格式 = " + formatter.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {
      ThreadLocalExample t = new ThreadLocalExample();
      for (int i = 0; i < 10; i++) {
        Thread task = new Thread(t, " " + i);
        Thread.sleep(new Random().nextInt(1000));
        task.start();
      }
    }
    //  ThreadLocal 内存泄露问题
    // ThreadLocalMap 中使用的 key 为 ThreadLocal 的弱引用,
    // 而 value 是强引用。所以，如果 ThreadLocal 没有被外部强引用的情况下，
    // 在垃圾回收的时候，key 会被清理掉，而 value 不会被清理掉。
    // 这样一来，ThreadLocalMap 中就会出现 key 为 null 的 Entry。
    // 假如我们不做任何措施的话，value 永远无法被 GC 回收，这个时候就可能会产生内存泄露。
    // ThreadLocalMap 实现中已经考虑了这种情况，在调用 set()、get()、remove() 方法的时候，会清理掉 key 为 null 的记录。使用完 ThreadLocal方法后 最好手动调用remove()方法
  }
  //endregion

  //region 锁ReentrantLock
  public static class LockDemo {
    private volatile int num = 50;
    Lock lock = new ReentrantLock(false);

    public void sale() {
      lock.lock();
      try {
        if (num > 0) {
          System.out.println(Thread.currentThread().getName() + " 卖出第 " + (num--) + "张票,剩余" + num);
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }

    public static void main(String[] args) {
      LockDemo lockDemo = new LockDemo();
      for (int i = 0; i < 3; i++) {
        new Thread(() -> {
          for (int j = 0; j < 50; j++) {
            lockDemo.sale();
          }
        }, "柜台" + i).start();
      }
    }

  }
  //endregion

  //region volatile特性验证
  public static class Atomicity {
    volatile int num = 0;
    Object o = new Object();
    AtomicInteger atomicInteger = new AtomicInteger();

    // 加60
    public void numTo60() {
      this.num = 60;
    }

    // 加1
    public void plus1() {
      this.num++;
    }

    public void addAtomic() {
      atomicInteger.getAndIncrement();
    }

    public static void main(String[] args) {
      atomicity();
    }

    /**
     * 验证原子性
     */
    public static void atomicity() {
      Atomicity atomicity = new Atomicity();
      for (int i = 0; i < 20; i++) {
        new Thread(() -> {
          for (int j = 0; j < 1000; j++) {
            atomicity.plus1();
            atomicity.addAtomic();
          }
        }, "线程1").start();
      }
      while (Thread.activeCount() > 2) {
        Thread.yield();
      }
      System.out.println(Thread.currentThread().getName() + "int finally number is " + atomicity.num);
      System.out.println(Thread.currentThread().getName() + "AtomicInteger finally number is " + atomicity.atomicInteger);
    }

  }
  //endregion

  //region 双重校验锁实现对象单例（线程安全）
  public static class Singleton {
    // 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
    // 作用是: 1.保证可见性 2.禁止指令重排 3.不保证原子性

    // 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。
    // 指令重排在单线程环境下不会出现问题，
    // 但是在多线程环境下会导致一个线程获得还没有初始化的实例。
    // 例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，
    // 因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
    private static volatile Singleton instance;

    public static Singleton getInstance() {
      if (instance == null) {
        synchronized (Singleton.class) {
          instance = new Singleton();
          return instance;
        }
      }
      return instance;
    }

    public static void main(String[] args) {
      Singleton s1 = Singleton.getInstance();
      Singleton s2 = Singleton.getInstance();
      System.out.println(s1 == s2);
      System.out.println(s1.equals(s2));
    }
  }
  //endregion

  //region Synchronized关键字
  static class Synchronized {
    static int i = 0;

    // 修饰方法
    // public synchronized void method1 () {
    public void method1() {
      i += 1;
      System.out.println(Thread.currentThread().getName() + "execute method " + i);
    }

    // 修饰静态方法
    public synchronized static void method() {
      // public static void method() {
      i += 1;
      System.out.println(Thread.currentThread().getName() + "execute method " + i);
    }

    // 修饰代码块
    public void method2() {
      synchronized (this) {
        i += 1;
        System.out.println(Thread.currentThread().getName() + "execute method " + i);
      }
    }

    public static void main(String[] args) {

      Synchronized aSynchronized1 = new Synchronized();

      for (int k = 0; k < 100; k++) {
        new Thread(() -> aSynchronized1.method2(), "线程1").start();
        new Thread(() -> aSynchronized1.method2(), "线程2").start();
        new Thread(() -> aSynchronized1.method2(), "线程3").start();
      }


      // // 普通方法
      // Synchronized aSynchronized = new Synchronized();
      // for (int j = 0; j < 100; j++) {
      //   new Thread(() -> aSynchronized.method1(), "线程1").start();
      //   new Thread(() -> aSynchronized.method1(), "线程2").start();
      // }

      // 静态方法
      // for (int i = 0; i < 100; i++) {
      //   new Thread(() -> method(), "线程1").start();
      //   new Thread(() -> method(), "线程2").start();
      // }
    }

  }
  //endregion

  //region 多线程
  static class MultiThread {
    public static void main(String[] args) {
      // 获取 Java 线程管理 MXBean
      ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
      // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
      ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
      // 遍历线程信息，仅打印线程 ID 和线程名称信息
      for (ThreadInfo threadInfo : threadInfos) {
        System.out.println("threadInfo.getThreadId() = " + threadInfo.getThreadId());
      }
    }
  }
  //endregion

  //region 死锁
  public static class DeadLock {
    private static Object assets1 = new Object(); // 资源1
    private static Object assets2 = new Object(); // 资源2

    public static void main(String[] args) {
      // 创建线程1
      new Thread(
        () -> {
          System.out.println("线程1开始");
          synchronized (assets1) {
            System.out.println(Thread.currentThread().getName() + " 获取资源1");

            try {
              Thread.sleep(3000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 等待获取资源2");
            synchronized (assets2) {
              System.out.println(Thread.currentThread() + " 获取资源2");
            }
          }
        }
        , "线程1"
      ).start();

      // 创建线程2
      // new Thread(
      //   () -> {
      //     synchronized (assets2) {
      //       System.out.println(Thread.currentThread().getName() + " 获取资源2");
      //
      //       try {
      //         Thread.sleep(1000);
      //       } catch (InterruptedException e) {
      //         e.printStackTrace();
      //       }
      //
      //       System.out.println(Thread.currentThread().getName() + " 等待获取资源1");
      //       synchronized (assets1) {
      //         System.out.println(Thread.currentThread() + " 获取资源1");
      //       }
      //     }
      //   }
      //   , "线程2"
      // ).start();

      // 创建线程3
      new Thread(
        () -> {
          System.out.println("线程3开始");
          synchronized (assets1) {
            System.out.println(Thread.currentThread().getName() + " 获取资源1");

            System.out.println(Thread.currentThread().getName() + " 等待获取资源2");
            try {
              Thread.sleep(1000);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            synchronized (assets2) {
              System.out.println(Thread.currentThread() + " 获取资源2");
            }
          }
        }
        , "线程2"
      ).start();

    }

  }
  //endregion

  // region sleep() 方法和 wait() 方法区别
  public static class SleepAndWait implements Runnable {
    int num = 1;

    public void method1() {
      synchronized (this) {
        System.out.println("method1()");
        num += 10;
        System.out.println("method1 num = " + num);
      }
    }

    public void method2() throws InterruptedException {
      synchronized (this) {
        // 以验证当前线程对象的机锁被占用时, 是否被可以访问其他同步代码块
        System.out.println("method2()");
        Thread.sleep(2000);
        // this.wait(2000);
        num *= 10;
        Thread.sleep(2000);
        System.out.println("method2 num = " + num);
      }
    }

    @Override
    public void run() {
      method1();
    }

    public static void main(String[] args) throws InterruptedException {
      SleepAndWait sleepAndWait = new SleepAndWait();
      Thread thread = new Thread(sleepAndWait);
      thread.start();
      sleepAndWait.method2();
    }
  }
  //endregion
}
