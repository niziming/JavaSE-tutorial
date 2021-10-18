package chap20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) throws IOException {
        File file = new File("itcast/chap20/demo3/1.png");
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream(new File("itcast/chap20/2.png"), false);
        byte[] b = new byte[128];
        in.read(b);
        int len;
        while ((len = in.read(b)) != -1)
            // System.out.print(Arrays.toString(b));
            out.write(b, 0, len);
        out.close();
        in.close();
    }
}
