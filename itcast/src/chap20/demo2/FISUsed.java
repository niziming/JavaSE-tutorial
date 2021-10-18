package chap20.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FISUsed {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("itcast/chap20/demo2/hello.txt");
        // 字节数组读取
        // byte[] b = new byte[127];
        // fis.read(b);
        // for (byte b1 : b) {
        //     System.out.print((char)b1);
        // }

        // 单个读取
        // int b;
        // while ((b = fis.read()) != -1) System.out.print((char)b);

        // 127容量接收
        int len;
        byte[] b = new byte[127];
        while ((len = fis.read(b)) != -1) {
            // System.out.print(new String(b));
            // 每次读取后,把数组的有效字节部分，变成字符串打印
            System.out.println(new String(b, 0, len));
        }

        fis.close();
    }
}
