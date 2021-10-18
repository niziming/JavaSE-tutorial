package chap21.demo7;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamUsed {
    public static void main(String[] args) throws IOException {
        System.out.println(97);
        PrintStream ps = new PrintStream("itcast/chap21/demo7/in.txt");
        System.setOut(ps);
        System.out.println(97);
    }
}
