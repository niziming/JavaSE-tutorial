package chap07;

import itcast.chap05.DefinitionArray;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Scanner类
        // Scanner scanner = new Scanner(System.in);
        // int i = scanner.nextInt();
        // System.out.println("用户输入: " + i);

        // 匿名对象
        // new Scanner(System.in);

        // Random类
        // Random random = new Random();
        // Random random1 = new Random();
        // System.out.println(random.nextInt(100));
        // System.out.println(random1.nextInt(100));

        // 对象数组
        Student[] s = new Student[3];
        s[0] = new Student("刘备", 40);
        s[1] = new Student("关羽", 35);
        s[2] = new Student("张飞", 30);
        DefinitionArray.ergodic(s);

        ArrayList<Student> list = new ArrayList<>();
        list.add(s[0]);
        list.add(s[1]);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}
