package cn.zm.data_structure;

public class Test {
  public static void main(String[] args) {
    test3();
    // test2();
    // test1();
    // test();
  }

  private static void test3() {
    short s1= 1;
    s1 += 1;
    System.out.println(s1);

  }

  private static void test() {
    Integer i1 = 100;
    Integer i2 = 100;
    Integer i3 = 200;
    Integer i4 = 200;
    System.out.println(i1 == i2);
    System.out.println(i3 == i4);
  }

  private static void test1() {
    Double i1 = 100.0;
    Double i2 = 100.0;
    Double i3 = 200.0;
    Double i4 = 200.0;
    System.out.println(i1 == i2);
    System.out.println(i3 == i4);
  }

  private static void test2() {
    Person person = new Person();
    Person person2 = new Person();
    System.out.println(person == person2);
  }

  static class Person {
    public Person() {
      System.out.println("Person");
    }

  }
}
