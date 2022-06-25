package chap21.demo2;

import java.io.*;

public class BufferedCharactor {
    public static void main(String[] args) throws IOException {
        File file = new File("itcast/chap21/demo2/hello.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter("itcast/chap21/demo2/out.txt"));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            System.out.println(line);
            System.out.println("-----------------");
        }

        bw.close();
        br.close();
    }
}
