package chap20.demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) throws IOException {
        // 到内存
        FileInputStream fis = new FileInputStream("itcast/chap20/demo3/1.png");
        // 出内存
        FileOutputStream fos = new FileOutputStream("itcast/chap20/demo3/copy.png");

        byte[] b = new byte[1024];
        int len;

        while ((len = fis.read(b)) != -1) {
            for (byte b1 : b) {
                System.out.print(b1);
                System.out.print(" ");
            }
            System.out.println();
            fos.write(b, 0, len);
        }

        File file = new File("itcast/chap20/demo3/1.png");
        long length = file.length();
        System.out.println(length);


        fos.close();
        fis.close();
    }
}
