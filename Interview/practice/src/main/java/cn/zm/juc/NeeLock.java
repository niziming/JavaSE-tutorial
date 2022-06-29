package cn.zm.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//region 自定义同步工具
//了解 AQS 基本原理以后，按照上面所说的 AQS 知识点，自己实现一个同步工具。
public class NeeLock {
  private Sync sync = new Sync();

  private static class Sync extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
      return compareAndSetState(0, 1);
    }

    @Override
    protected boolean tryRelease(int arg) {
      setState(0);
      return true;
    }

    @Override
    protected boolean isHeldExclusively() {
      return getState() == 1;
    }
  }
  public void lock () {
    sync.acquire(1);
  }

  public void unlock () {
    sync.release(1);
  }

  static int count = 0;
  static NeeLock lock = new NeeLock();
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        lock.lock();
        for (int i = 0; i < 111; i++) {
          count++;
        }
      } finally {
        lock.unlock();
      }
    }, "thread1");
    Thread thread2 = new Thread(() -> {
      try {
        lock.lock();
        for (int i = 0; i < 111; i++) {
          count++;
        }
      } finally {
        lock.unlock();
      }
    }, "thread2");
    System.out.println("start = ");
    thread.start();
    thread2.start();
    thread.join();
    thread2.join();
    System.out.println("count = " + count);
  }

}
//endregion