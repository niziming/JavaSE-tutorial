package itcast.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Copy {
    public static void main(String[] args) throws IOException {
        File file = new File("itcast/day20/1.png");
        FileInputStream in = new FileInputStream(file);
        // FileOutputStream out = new FileOutputStream(file.getName(), false);
        byte[] b = new byte[128];
        in.read(b);
        int len;
        // while ((len = in.read(b)) != -1)
            System.out.print(Arrays.toString(b));
            // out.write(b, 0, len);
        // out.close();
        in.close();
    }
}
