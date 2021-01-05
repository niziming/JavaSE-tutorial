package itcast.chap20.demo4;

import java.io.FileReader;
import java.io.IOException;

public class FRC {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("itcast/chap20/demo4/hello.txt");
        char[] chars = new char[128];
        int len;
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }
        fr.close();
    }
}
