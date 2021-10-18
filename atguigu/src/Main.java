import java.io.*;

public class Main {
    public static void main(String[] args) {
        // for (int i = 1; i < 19; i++) {
        //     String fileName = "atguigu/chap" + i;
        //     File file = new File(fileName);
        //     if (!file.exists()) file.mkdir();
        // }

        cutFile("atguigu/chap1overview", "atguigu/chap2grammar");
    }
    // file cut
    public static File cutFile(String source, String target){

        File targetFile = null;

        try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(target);
        ){
            targetFile = new File(target);
            File file = new File(source);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return targetFile;

    }
}
