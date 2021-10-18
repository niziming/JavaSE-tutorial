package chap21.demo1;

import java.io.*;
import java.text.NumberFormat;

public class BufferedDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("itcast/chap21/day21【缓冲流、转换流、序列化流、打印流】-笔记.pdf");
        long fileLen = file.length();

        NumberFormat pi = NumberFormat.getPercentInstance();

        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream("itcast/chap21/demo1/copy.pdf");) {
            int len, count = 1;
            byte[] b = new byte[1];
            while ((len = fis.read(b)) != -1) {
                System.out.println("拷贝进度: " + pi.format(count*1.0/fileLen));
                fos.write(b, 0, len);
                count++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("普通流总耗时: " + (end - start) + "ms");

        long start1 = System.currentTimeMillis();
        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("itcast/chap21/demo1/copy.pdf"));) {
            int len;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("缓冲流总耗时: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("itcast/chap21/demo1/copy.pdf"));) {
            byte[] bytes = new byte[8*1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("缓冲流数组总耗时: " + (end2 - start2) + "ms");
    }
}
