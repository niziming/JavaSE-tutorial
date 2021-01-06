package itcast.chap21.demo5;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class OOS {
    public static void main(String[] args) {
        String fp = "itcast/chap21.demo5/employee.txt";
        try (
                FileOutputStream fos = new FileOutputStream(fp);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
