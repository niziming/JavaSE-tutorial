package cn.zm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 获取用键盘输入常用的两种方法
 */
public class ScannerDemo {
  // 方法 1：通过 Scanner
  public static void scanner() {
    while (true) {
      Scanner in = new Scanner(System.in);
      String next = in.next();
      System.out.println(next);
      if ("exit".equals(next)) {
        in.close();
        return;
      }
    }
  }

  // 方法 2：通过 BufferedReader
  public static void scanner1() {
    StringBuilder sb = new StringBuilder();
    while (true) {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      try {
        String next = in.readLine();
        sb.append(next+ "-");
        System.out.println(sb);
        if ("exit".equals(next)) {
          in.close();
          return;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    scanner1();
    // scanner();
  }
}
