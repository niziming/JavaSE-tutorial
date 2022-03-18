package lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class MainTest {
  int money = 0;
  ReentrantLock lock = new ReentrantLock();

  public void order() {
    lock.lock();
    try {
    money += 1;
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) throws InterruptedException {

    final CountDownLatch count = new CountDownLatch(100000);

    MainTest myLock = new MainTest();

    for (int i = 0; i < 1000; i++) {
      new Thread(() -> {
        for (int j = 0; j < 100; j++) {
          myLock.order();
          count.countDown();
        }
      }).start();
    }

    count.await();

    System.out.println("myLock.money = " + myLock.money);
  }
}
