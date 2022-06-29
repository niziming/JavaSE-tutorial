package cn.zm.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class JUC {


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

  //region ReentrantLock锁
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

  //region ReentrantLock 和 Synchronized 比较
  public static class ReentrantLockVSSynchronized {
    //region Synchronized

    /**
     * Synchronized
     */
    public synchronized void sync() {

    }

    public void synchronizedExample() {
      synchronized (this) {
      }
      synchronized (new Object()) {
      }
      for (int i = 0; i < 10; i++) {
        synchronized (this) {
          System.out.println(Thread.currentThread().getName() + "可重入");
        }
      }
    }

    /**
     * classLock
     */
    public static void classLock() {
      synchronized (ReentrantLockVSSynchronized.class) {
      }
    }
    //endregion

    public static void main(String[] args) {
      // new ReentrantLockVSSynchronized().synchronizedExample();

      for (int i = 0; i < 10; i++) {
        reentrantLockExample();
      }
    }

    //region ReentrantLock

    /**
     * ReentrantLock
     */
    public static void reentrantLockExample() {
      // 1.初始化选择公平锁、非公平锁
      ReentrantLock lock = new ReentrantLock(true);
      // 2.可用于代码块
      lock.lock();
      try {
        // 3.支持多种加锁方式，比较灵活; 具有可重入特性
        if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
          System.out.println(Thread.currentThread().getName()+"-reentrant");
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }


    }
    //endregion

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

  //region LockTest 待完善
  public static class LockDemo1 {
    // volatile可见性，变量变更始终从主存中获取最新值，而不存在延迟。
    volatile Boolean keepRunning = true;
    Lock lock = new ReentrantLock(false);

    /**
     * instans lock
     */
    public void instansLock() {
      try {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ("成功获取锁"));
        while (keepRunning) {
          Thread.sleep(2000);
          System.out.println(Thread.currentThread().getName() + "used assets");
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + "-释放锁-结束");
      }
    }

    public Lock getLock() {
      return lock;
    }

    public static void main(String[] args) throws InterruptedException {
      LockDemo1 lockDemo = new LockDemo1();
      // Lock lock = lockDemo.getLock();
      Thread thread = new Thread(() -> lockDemo.instansLock(), "线程1");
      // Thread thread1 = new Thread(() -> lockDemo.notify());
      thread.start();
      // lock.wait(1000);

      new Thread(() -> {
        lockDemo.instansLock();
      }, "线程2").start();

      // Thread.sleep(1000);
      // thread1.start();
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
