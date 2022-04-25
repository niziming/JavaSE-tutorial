package cn.zm.juc;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal
 */
public class ThreadLocalExample {

  //region ThreadLocalUsed 父子线程不可共享副本数据
  public static class ThreadLocalUsed {
    private List<String> msg = Lists.newArrayList();
    public static final ThreadLocal<ThreadLocalUsed> holder = ThreadLocal.withInitial(ThreadLocalUsed::new);

    /**
     * 添加
     */
    public static void add(String msg) {
      holder.get().msg.add(msg);

    }

    //region 清除
    public static List<String> clear() {
      List<String> msg = holder.get().msg;
      holder.remove();
      System.out.println("size = " + holder.get().msg.size());
      return msg;
    }
    //endregion

    public static void main(String[] args) throws InterruptedException {
      Thread thread = new Thread(() -> {
        ThreadLocalUsed.add("资源a");
        ThreadLocalUsed.add("资源b");
        System.out.println(holder.get().msg);
        ThreadLocalUsed.clear();
      }, "线程1");
      thread.start();
      thread.join();
      System.out.println("线程1执行结束");
      new Thread(() -> {
        ThreadLocalUsed.add("资源c");
        ThreadLocalUsed.add("资源d");
        System.out.println(holder.get().msg);
        ThreadLocalUsed.clear();
      }, "线程1").start();

    }
  }
  //endregion

  //region GC 无强引用时会被自动回收
  public static class ThreadLocalGC {
    public static void main(String[] args) throws InterruptedException {
      Thread t = new Thread(()->GC("abc",false));
      t.start();
      t.join();
      System.out.println("--gc后--");
      Thread t2 = new Thread(() -> GC("def", true));
      t2.start();
      t2.join();
    }

    /**
     * GC
     */
    public static void GC(String s, Boolean isGC) {
      try {
        new ThreadLocal<>().set(s);
        // ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        // threadLocal.set(s);
        if (isGC) System.gc();
        // 获取当前线程
        Thread t = Thread.currentThread();
        // 获取线程类
        Class<? extends Thread> clz = t.getClass();
        // 反射获取属性
        Field field = clz.getDeclaredField("threadLocals");
        // 取消访问检查
        field.setAccessible(true);
        Object threadLocalMap = field.get(t);
        Class<?> tlmClz = threadLocalMap.getClass();
        Field tableField = tlmClz.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] arr = (Object[]) tableField.get(threadLocalMap);
        for (Object o : arr) {
          if (o != null) {
            Class<?> entryClass = o.getClass();
            Field valueField = entryClass.getDeclaredField("value");
            Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
            valueField.setAccessible(true);
            referenceField.setAccessible(true);
            System.out.println(String.format("弱引用key:%s,值:%s", referenceField.get(o), valueField.get(o)));
          }
        }
      } catch (NoSuchFieldException | IllegalAccessException e) {
        e.printStackTrace();
      }


    }

  }
  //endregion

  //region ThreadLocalMap Hash 算法
  public static class ThreadLocalMapHash {
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
      int hashCode = 0;
      for (int i = 0; i < 16; i++) {
        hashCode = (i + 1) * HASH_INCREMENT;
        int bucket = hashCode & 15;
        System.out.println(i + "在桶中的位置" + bucket);
      }
    }

  }
  //endregion

  //region InheritableThreadLocal 父子线程共享副本数据
  public static class InheritableThreadLocalExample {
    public static void main(String[] args) {
      ThreadLocal<String> tl = new ThreadLocal<>();
      InheritableThreadLocal<String> itl = new InheritableThreadLocal<>();
      tl.set("父类数据: threadlocal");
      itl.set("父类数据: InheritableThreadLocal");

      new Thread(() -> {
        System.out.println("ThreadLocal子线程获取: " + tl.get());
        System.out.println("InheritableThreadLocal子线程获取: " + itl.get());
      }, "线程1").start();
    }

  }
  //endregion

  //region TransmittableThreadLocal 解决线程池InheritableThreadLocal复用问题
  // 但InheritableThreadLocal仍然有缺陷，
  // 一般我们做异步化处理都是使用的线程池，
  // 而InheritableThreadLocal是在new Thread中的init()方法给赋值的，
  // 而线程池是线程复用的逻辑，所以这里会存在问题。
  public static class TransmittableThreadLocalExample {
    static ThreadLocal<Integer> ttl = new TransmittableThreadLocal();

    public static void main(String[] args) {
      ExecutorService threadPool = Executors.newFixedThreadPool(10);
      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName());
        ttl.set(i);
        threadPool.execute(() -> {
          method1();
        });
      }
      threadPool.shutdown();
    }


    /**
     * method1
     */
    public static void method1() {
      method2();
    }

    /**
     * method2
     */
    public static void method2() {
      System.out.println(Thread.currentThread().getName());
      System.out.println(ttl.get());
    }


  }
  //endregion

  // region ThreadLocal
  // 通常情况下，我们创建的变量是可以被任何一个线程访问并修改的。
  // 如果想实现每一个线程都有自己的专属本地变量该如何解决呢？
  // JDK 中提供的ThreadLocal类正是为了解决这样的问题。
  // ThreadLocal类主要解决的就是让每个线程绑定自己的值，
  // 可以将ThreadLocal类形象的比喻成存放数据的盒子，
  // 盒子中可以存储每个线程的私有数据。
  public static class ThreadLocalExample1 implements Runnable {

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
        Thread task = new Thread(t + " " + i);
        Thread.sleep(new Random().nextInt(1000));
        task.start();
      }
    }
    // ThreadLocal 内存泄露问题
    // ThreadLocalMap 中使用的 key 为 ThreadLocal 的弱引用,
    // 而 value 是强引用。所以，如果 ThreadLocal 没有被外部强引用的情况下，
    // 在垃圾回收的时候，key 会被清理掉，而 value 不会被清理掉。
    // 这样一来，ThreadLocalMap 中就会出现 key 为 null 的 Entry。
    // 假如我们不做任何措施的话，value 永远无法被 GC 回收，这个时候就可能会产生内存泄露。
    // ThreadLocalMap 实现中已经考虑了这种情况，在调用 set()、get()、remove() 方法的时候，
    // 会清理掉 key 为 null 的记录。使用完 ThreadLocal方法后 最好手动调用remove()方法
  }
  //endregion
}
