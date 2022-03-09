package chap20.demo5;

import java.io.FileWriter;
import java.io.IOException;

public class FWC {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("itcast/chap20/demo5/test.txt", true);
        // 写出字符数组
        // fw.write("hello".toCharArray());

        // 写出从索引0开始，3个字节。索引0是'h'，两个字节，也就是'hel'        
        // fw.write("hello", 0, 3);

        // 续写和换行
        fw.write(" \r\n".toCharArray());
        fw.write(" ziming".toCharArray());


        fw.close();
    }
}
