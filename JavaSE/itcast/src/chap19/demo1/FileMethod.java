package chap19.demo1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileMethod {
    public static void main(String[] args) {
        File file = new File("itcast/chap19/demo1/hello.txt");
        System.out.println("绝对路径: " + file.getAbsolutePath());
        System.out.println("构造路径: " + file.getPath());
        System.out.println("文件名: " + file.getName());
        System.out.println("文件长度(字节): " + file.length());
        System.out.println("是否存在: " + file.exists());
        System.out.println("是否目录: " + file.isDirectory());
        System.out.println("是否文件: " + file.isFile());
        if (file.exists()) {
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file1 = new File("itcast/chap19/demo1/test/hello");
        if (file1.exists()) {
            file1.delete();
        } else {
            // file1.mkdir();
            file1.mkdirs();
        }

        File file2 = new File("itcast/chap19/demo1");
        String[] list = file2.list();
        System.out.println(Arrays.toString(list));

    }
}
