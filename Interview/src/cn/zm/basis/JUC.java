package cn.zm.basis;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class JUC {

  //region Synchronized关键字
  static class Synchronized {
    static int i = 0;
    public synchronized static void method() {
      i += 1;
      // todo
      System.out.println(Thread.currentThread().getName() + "execute method " + i);
    }

    public static void main(String[] args) {
      for (int i = 0; i < 100; i++) {
        new Thread(() -> method(), "线程1").start();
        new Thread(() -> method(), "线程2").start();
      }
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
        // Thread.sleep(2000);
        this.wait(2000);
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
