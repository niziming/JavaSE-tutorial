package itcast.day19.demo;

import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File dir = new File("day20");
        printDir2(dir, "Demo1");
    }

    private static void printDir2(File dir, String filname) {
        // 匿名内部类方式,创建过滤器子类对象
        File[] files = dir.listFiles(f -> f.getName().startsWith(filname) || f.isDirectory());
        if (files == null) {
            System.out.println("文件为空");
            return;
        }
        // 循环打印
        System.out.println(files);
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                printDir2(file, filname);
            }
        }
    }
}
