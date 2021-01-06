package itcast.chap21.demo4;

import java.io.*;

public class OSW {
    public static void main(String[] args) {
        String filePath = "itcast/chap21/demo4/out.txt";
        try
            (
                    FileOutputStream fis = new FileOutputStream(filePath);
                    // OutputStreamWriter osw = new OutputStreamWriter(fis);
                    // OutputStreamWriter osw1 = new OutputStreamWriter(fis, "UTF-8");
                    OutputStreamWriter osw2 = new OutputStreamWriter(fis, "GBK");
            )
        {
            // osw.write("osw 测试1");
            // osw1.write("osw 测试1");
            osw2.write("osw 测试1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
