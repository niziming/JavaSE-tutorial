package cn.zm.juc;

//region Atomic 原子类
// Atomic 翻译成中文是原子的意思。在化学上，我们知道原子是构成一般物质的最小单位，
// 在化学反应中是不可分割的。在我们这里 Atomic 是指一个操作是不可中断的。
// 即使是在多个线程一起执行的时候，一个操作一旦开始，就不会被其他线程干扰。

import java.util.concurrent.atomic.*;

// 并发包 java.util.concurrent 的原子类都存放在java.util.concurrent.atomic下,如下图所示。
public class AtomicExample {
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

  //region AtomicReference 类使用实例
  public static class AtomicReferenceExample {
    public static void main(String[] args) {
      AtomicReference<Person> ar = new AtomicReference<>();
      Person p1 = new AtomicReferenceExample().new Person("Sna", 22);
      ar.set(p1);
      Person p2 = new AtomicReferenceExample().new Person("Aea", 22);
      ar.set(p2);

      System.out.println(ar.get());



    }
    class Person {
      private String name;
      private int age;

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public int getAge() {
        return age;
      }

      public void setAge(int age) {
        this.age = age;
      }

      public Person() {
      }

      public Person(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
      }
    }

  }
  //endregion

  //region AtomicStampedReference 类使用示例
  public static class AtomicStampedReferenceExample {

    public void example() {
      final Integer initialRef = 0, initialStamp = 0;
      final AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(initialRef, initialStamp);
      System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());

      // compare and set
      final Integer newReference = 666, newStamp = 999;
      final boolean casResult = asr.compareAndSet(initialRef, newReference, initialStamp, newStamp);
      System.out.println("currentValue=" + asr.getReference()
        + ", currentStamp=" + asr.getStamp()
        + ", casResult=" + casResult);

      // 获取当前的值和当前的 stamp 值
      int[] arr = new int[1];
      final Integer currentValue = asr.get(arr);
      final int currentStamp = arr[0];
      System.out.println("currentValue=" + currentValue + ", currentStamp=" + currentStamp);

      // 重新设置当前值和 stamp 值
      asr.set(initialRef, initialStamp);
      System.out.println("currentValue=" + asr.getReference() + ", currentStamp=" + asr.getStamp());

      // [不推荐使用，除非搞清楚注释的意思了] weak compare and set
      // 困惑！weakCompareAndSet 这个方法最终还是调用 compareAndSet 方法。[版本: jdk-8u191]
      // 但是注释上写着 "May fail spuriously and does not provide ordering guarantees,
      // so is only rarely an appropriate alternative to compareAndSet."
      // todo 感觉有可能是 jvm 通过方法名在 native 方法里面做了转发
      final boolean wCasResult = asr.weakCompareAndSet(initialRef, newReference, initialStamp, newStamp);
      System.out.println("currentValue=" + asr.getReference()
        + ", currentStamp=" + asr.getStamp()
        + ", wCasResult=" + wCasResult);

    }
    public static void main(String[] args) {
      new AtomicStampedReferenceExample().example();
    }

  }
  //endregion
}
//endregion
