package lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class MyLock implements Lock {
  // 设置拥有者线程
  AtomicReference<Thread> ownerThread = new AtomicReference<>();
  // 阻塞队列
  LinkedBlockingQueue<Thread> waitQueue = new LinkedBlockingQueue<>();

  @Override
  public void lock() {
    while (!tryLock()) {
      // 获取失败, 将当前线程放入阻塞队列
      waitQueue.add(Thread.currentThread());
      // 将当前线程挂起
      LockSupport.park();
      // 当线程被唤醒, 将当前线程从阻塞队列中移除
      waitQueue.remove(Thread.currentThread());
    }
  }

  @Override
  public void lockInterruptibly() throws InterruptedException {

  }
  /**
   * 通过cas进行加锁，如果cas成功则返回true，如果失败则返回false
   */
  @Override
  public boolean tryLock() {
    return ownerThread.compareAndSet(null, Thread.currentThread());
  }


  @Override
  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }

  @Override
  public void unlock() {
    if (ownerThread.compareAndSet(Thread.currentThread(), null)) {
      for (Thread thread : waitQueue) {
        LockSupport.unpark(thread);
      }
    }
  }

  @Override
  public Condition newCondition() {
    return null;
  }

  int money = 100;
  MyLock lock = new MyLock();

  public void order() {

    // lock.lock();
    // try {
      money += 1;
    // } finally {
    //   lock.unlock();
    // }
  }

}
