package chap16.demo2;

import java.io.FileNotFoundException;

public class TryCatchDemo4 {
    public static void main(String[] args) {
        try {
            read("hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void read(String path) throws FileNotFoundException{
        if (!"a.txt".equals(path)) {
            throw new FileNotFoundException("文件不存在");
        }
    }
}
