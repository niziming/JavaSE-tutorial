package itcast.chap19.demo;

import java.io.File;

public class Demo2 {
    public static void main(String[] args) {
        File f = new File("day20");
        method(f);
    }
    public static void method(File f){
        File[] files = f.listFiles();
        for (File f1 : files) {
            if (f1.isFile()) {
                if (f1.getName().endsWith(".java")) {
                    System.out.println("文件名:" + f1.getName());
                }
            }
            else {
                System.out.println("文件夹" + f.getAbsolutePath());
                method(f1);
            }
        }
    }
}
