package cn.zm;

public class ThrowableDemo {
  public static void main(String[] args) {
    try {
      System.out.println("Hello World!");
      throw new RuntimeException("Hello World!");
    } catch (RuntimeException e) {
      Class<? extends RuntimeException> aClass = e.getClass();
      String message = e.getMessage();
      e.printStackTrace();
    } finally {
      System.out.println("finally");
    }
  }
}
