package chap20.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FISC {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("itcast/chap20/demo2/hello.txt");
        FileInputStream fis = new FileInputStream(new File("itcast/chap20/demo2/hello.txt"));

    }
}
