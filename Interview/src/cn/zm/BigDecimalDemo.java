package cn.zm;

import java.math.BigDecimal;

// BigDecimal解决浮点数运算精度丢失问题
// 《阿里巴巴 Java 开发手册》中提到：“为了避免精度丢失，可以使用 BigDecimal 来进行浮点数的运算”。
public class BigDecimalDemo {
  public static void main(String[] args) {
    lostPrecision2();
    // lostPrecision1();
    // lostPrecision();
  }

  private static void lostPrecision2() {
    BigDecimal a = new BigDecimal("1.0");
    BigDecimal b = new BigDecimal("0.9");
    BigDecimal c = new BigDecimal("0.8");

    BigDecimal x = a.subtract(b);
    BigDecimal y = b.subtract(c);

    System.out.println(x);
    System.out.println(y);
    System.out.println(x.equals(y));


  }

  private static void lostPrecision1() {
    System.out.println(2 >> 1);
    System.out.println(2 << 1);
    System.out.println(2 << 4);
    System.out.println(5 << 1);
    System.out.println(5 << 2);
    System.out.println(5 << 3);
    System.out.println(5 << 4);
  }

  private static void lostPrecision() {
    float r1 = 1.0F - 0.9F;
    float r2 = 0.9F - 0.8F;

    System.out.println("r1 = " + r1);
    System.out.println("r2 = " + r2);
    System.out.println(r2 == r1);

  }
}
