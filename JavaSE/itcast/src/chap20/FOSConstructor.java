package chap20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSConstructor {
    public static void main(String[] args) {
        File f = new File("doc.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(f);
            FileOutputStream fos1 = new FileOutputStream("doc.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
