package itcast.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FISConstructor{
    public static void main(String[]args) throws IOException {
        // File file = new File("fos.txt");
        // FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fis = new FileInputStream("itcast/day20/day20【字节流、字符流】-笔记.pdf");
        // int read = fis.read();
        // System.out.println((char)read);
        // read = fis.read();
        // System.out.println((char)read);
        // read = fis.read();
        // System.out.println((char)read);
        // int read;
        // while ((read = fis.read()) != -1) {
        //     System.out.print((char)read);
        // }
        int len;
        byte[] b = new byte[128];
        len = fis.read(b);
        // while((len = fis.read(b)) != -1)
            System.out.print(new String(b, 0, len));
        fis.close();
    }
}
