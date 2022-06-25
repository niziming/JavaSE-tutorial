package chap20;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/*
    写出字节数据
 */
public class FOSWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象, 如果文件不存在会自动创建文件
        FileOutputStream fos = new FileOutputStream("fos.txt", true);
        // fos.write(97);
        // fos.write(98);
        // fos.write(99);
        // 写出字符数组
        byte[] bytes = "hello world".getBytes();
        // System.out.println(Arrays.toString(bytes));
        // fos.write(bytes);
        // 写出指定长度字节数组： write(byte[] b, int off, int len)
        int off = 2;
        ArrayList<Byte> a = new ArrayList();
        System.out.println();
        fos.write((int) '\n');
        fos.write(bytes, off, bytes.length-off);
        fos.close();
    }
}
