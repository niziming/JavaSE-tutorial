package chap19.demo1;

import java.io.File;

public class FileUsed {
    public static void main(String[] args) {
        // 构造方法
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());

        String parent = "parent";
        File file1 = new File(parent, "hello.txt");
        System.out.println(file.getAbsolutePath());

        File parent1 = new File("parent");
        File file2 = new File(parent1, "hello.txt");
        System.out.println(file.getPath());

    }
}
