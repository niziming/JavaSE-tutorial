package chap20.demo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSC  {
    public static void main(String[] args) throws IOException{
        // 构造方法
        File file = new File("itcast/chap20/demo3/1.png");
        FileOutputStream fos = new FileOutputStream(file);
        FileOutputStream fos1 = new FileOutputStream("itcast/chap20/demo3/1.png");

        // 写入文件 append 为持续追加
        FileOutputStream fos2 = new FileOutputStream("itcast/chap20/demo1/1.txt", true);
        fos2.write(97);
        fos2.write(98);
        fos2.write(99);
        fos2.write("\nlife is fucking movie = 人生如戏\n".getBytes());
        fos2.close();

        run("hello");
    }

    private static void run(String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream("itcast/chap20/demo1/" + fileName + ".txt", true);
        fos.write("\n".getBytes());
        for (int i = 32; i < 127; i++) {
            if (i% 10 == 0) {
                fos.write("\n".getBytes());
            } else {
                fos.write(Integer.toString(i).concat(": ").getBytes());
                fos.write(i);
                fos.write(' ');
            }
        }

    }
}
