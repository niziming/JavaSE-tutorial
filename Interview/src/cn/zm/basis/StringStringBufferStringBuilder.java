package cn.zm.basis;

import java.time.Clock;

public class StringStringBufferStringBuilder {
  public static void main(String[] args) {
    String a = "hello";
    StringBuffer b = new StringBuffer(StringBuffer.class.getName());
    StringBuilder c = new StringBuilder(StringBuilder.class.getName());
    b.append("-world");
    c.append("-world");
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    Clock clock = Clock.systemDefaultZone();
    long start = clock.millis();
    for (int i = 0; i < 1000; i++) {
      c.append(i);
    }
    long end = clock.millis();
    System.out.println(end - start);
    long start1 = clock.millis();
    for (int i = 0; i < 1000; i++) {
      a+=i;
    }
    long end1 = clock.millis();
    System.out.println(end1 - start1);

    // #String#equals() 和 Object#equals() 有何区别？
    // String 中的 equals 方法是被重写过的，比较的是 String 字符串的值是否相等。 Object 的 equals 方法是比较的对象的内存地址。

    // 字符串常量池 是 JVM 为了提升性能和减少内存消耗针对字符串（String 类）专门开辟的一块区域，主要目的是为了避免字符串的重复创建。

    String aa = "ab"; // 放在常量池中
    String bb = "ab"; // 从常量池中查找
    System.out.println(aa==bb);// true
  }
}
