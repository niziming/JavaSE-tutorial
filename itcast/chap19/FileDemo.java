package itcast.day19;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo {
    public static void main(String[] args) {
        String path = "aaa.txt";
        String parent = "D:\\";
        String child = "aaa.txt";
        File file = new File(path);
        File file1 = new File(parent, child);
        File dir = new File(parent);
        File file3 = new File(dir, child);
        System.out.println("文件绝对路径:" + file.getAbsolutePath());
        System.out.println("文件构造路径:" + file.getPath());
        System.out.println("文件名称:" + file.getName());
        System.out.println("文件长度:" + file.length() + "字节");

        File f2 = new File("day19");
        System.out.println("目录绝对路径:" + f2.getAbsolutePath());
        System.out.println("目录构造路径:" + f2.getPath());
        System.out.println("目录名称:" + f2.getName());
        System.out.println("目录长度:" + f2.length());
        System.out.println("目录存在:" + f2.exists());
        System.out.println("文件存在:" + file.exists());
        System.out.println(file.getName() + "是否是文件:" + f2.isFile());
        System.out.println(f2.getName() + "是否是文件:" + f2.isFile());
        System.out.println(file1.getName() + "是否是文件夹:" + f2.isDirectory());
        System.out.println(f2.getName() + "是否是文件夹:" + f2.isDirectory());
        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else file.delete();
        // File hello = new File("day21\\hello\\world");
        File hello = new File("day21");
        // if (hello.exists() == false) hello.mkdir();
        if (hello.exists() == false) hello.mkdirs();
        String[] list = hello.list();
        File[] files = hello.listFiles();
        System.out.println(Arrays.toString(list));
        for (File f : files) {
            System.out.println(f.getName());
        }
    }
}
