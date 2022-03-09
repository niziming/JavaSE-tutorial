package chap21.demo4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISR {
    public static void main(String[] args) {
        String filePath = "itcast/chap21/demo4/in.txt";
        try
            (
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            InputStreamReader isr1 = new InputStreamReader(fis, "UTF-8");
            InputStreamReader isr2 = new InputStreamReader(fis, "GBK");
            )
        {
            char[] c = new char[10];

            int read = isr.read(c);
            System.out.println(c);

            int read1 = isr1.read(c);
            System.out.println(c);

            int read2 = isr2.read(c);
            System.out.println(c);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
