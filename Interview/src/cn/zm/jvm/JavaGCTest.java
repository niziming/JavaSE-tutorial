package cn.zm.jvm;

public class JavaGCTest {
  /**
   * VM OPTIONS
   * -verbose:gc
   * -Xmx200M
   * -Xms200M
   * -Xmn50M
   * -XX:+PrintGCDetails
   * -XX:TargetSurvivorRatio=60
   * -XX:+PrintTenuringDistribution
   * -XX:+PrintGCDateStamps
   * -XX:MaxTenuringThreshold=3
   * -XX:+UseConcMarkSweepGC
   * -XX:+UseParNewGC
   * @param args
   */
  public static void main(String[] args) {
    // 空跑一次main函数来查看java服务本身占用的空间大小，我这里是占用了3M。所以40-3=37，下面分配三个1M的数组和一个34M的垃圾数组。

    // 为了达到TargetSurvivorRatio（期望占用的Survivor区域的大小）这个比例指定的值, 即5M*60%=3M(Desired survivor size)，
    // 这里用1M的数组的分配来达到Desired survivor size
    // 说明: 5M为S区的From或To的大小，60%为TargetSurvivorRatio参数指定,可以更改参数获取不同的效果。
    byte[] byte1m_1 = new byte[1 * 1024 * 1024];
    byte[] byte1m_2 = new byte[1 * 1024 * 1024];
    byte[] byte1m_3 = new byte[1 * 1024 * 1024];

    //使用函数方式来申请空间，函数运行完毕以后，就会变成垃圾等待回收。此时应保证eden的区域占用达到100%。可以通过调整传入值来达到效果。
    makeGarbage(34);

    //再次申请一个数组，因为eden已经满了，所以这里会触发Minor GC
    byte[] byteArr = new byte[10 * 1024 * 1024];
    // 这次Minor Gc时, 三个1M的数组因为尚有引用，所以进入From区域（因为是第一次GC）age为1
    // 且由于From区已经占用达到了60%(-XX:TargetSurvivorRatio=60), 所以会重新计算对象晋升的age。
    // 计算方法见上文，计算出age：min(age, MaxTenuringThreshold) = 1，输出中会有Desired survivor size 3145728 bytes, new threshold 1 (max 3)字样
    //新的数组byteArr进入eden区域。

    //再次触发垃圾回收，证明三个1M的数组会因为其第二次回收后age为2，大于上一次计算出的new threshold 1，所以进入老年代。
    //而byteArr因为超过survivor的单个区域，直接进入了老年代。
    makeGarbage(34);
  }

  private static void makeGarbage(int size) {
    byte[] bytes = new byte[size * 1024 * 1024];
  }


  //region GCTEST
  public static class GCTEST {
    public static void main(String[] args) {
      byte[] allocation1, allocation2;
      allocation1 = new byte[30900*1024];
      allocation2 = new byte[900*1024];
    }

  }
  //Heap
  //  PSYoungGen      total 114176K, used 38764K [0x0000000740b80000, 0x0000000748a80000, 0x00000007c0000000)
  //   eden space 98304K, 39% used [0x0000000740b80000,0x000000074315b308,0x0000000746b80000)
  //   from space 15872K, 0% used [0x0000000747b00000,0x0000000747b00000,0x0000000748a80000)
  //   to   space 15872K, 0% used [0x0000000746b80000,0x0000000746b80000,0x0000000747b00000)
  //  ParOldGen       total 261120K, used 0K [0x0000000642200000, 0x0000000652100000, 0x0000000740b80000)
  //   object space 261120K, 0% used [0x0000000642200000,0x0000000642200000,0x0000000652100000)
  //  Metaspace       used 3240K, capacity 4496K, committed 4864K, reserved 1056768K
  //   class space    used 352K, capacity 388K, committed 512K, reserved 1048576K
  //endregion

  // 引用计数法
  public static class ReferenceCountingGc {
    Object instance = null;
    public static void main(String[] args) {
      ReferenceCountingGc objA = new ReferenceCountingGc();
      ReferenceCountingGc objB = new ReferenceCountingGc();
      objA.instance = objB;
      objB.instance = objA;
      objA = null;
      objB = null;

    }
  }
}
