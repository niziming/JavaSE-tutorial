package cn.zm;

import java.util.Arrays;

// 为什么 Java 只有值传递？
public class JavaValueTransmit {

  /**
   * 基本数据类型引用
   */
  static class BaseDataType {
    // 形参 和  实参
    private static void method1() {
      String str = "hello";
      sayHello(str);
      System.out.println("str = " + str);
    }

    private static void sayHello(String strParam) {
      strParam = "world";
      System.out.println("str = " + strParam);
    }

    public static void main(String[] args) {
      method1();
    }
  }

  /**
   * 引用数据类型值传递
   */
  static class ReferenceDataType {

    // 结果发生了改变, 但是还是值传递而不是引用传递, 传递的值为引用类型的地址值
    public static void main(String[] args) {
      int[] arr = {1,2,3};
      System.out.println(Arrays.toString(arr));
      change(arr);
      System.out.println(Arrays.toString(arr));
    }

    private static void change(int[] array) {
      array[0] = 0;

    }
  }


  // 证明: 值传递
  static class Person {
    private String name;

    public Person(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Person{" +
        "name='" + name + '\'' +
        '}';
    }

    public static void main(String[] args) {
      Person p1 = new Person("张三");
      Person p2 = new Person("李四");
      swap(p1, p2);
      System.out.println("p1:" + p1);
      System.out.println("p2:" + p2);
    }

    private static void swap(Person p1, Person p2) {
      Person temp = p1;
      p1 = p2;
      p2 = temp;
      System.out.println("p1:" + p1);
      System.out.println("p2:" + p2);
    }

  }

}
