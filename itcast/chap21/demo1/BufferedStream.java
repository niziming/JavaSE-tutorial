package itcast.chap21.demo1;

import java.io.*;

public class BufferedStream {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("itcast/chap21/demo1/test.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("itcast/chap21/demo1/test.txt"));
    }
}
