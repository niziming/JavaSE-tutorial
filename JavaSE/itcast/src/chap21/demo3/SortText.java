package chap21.demo3;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SortText {
    public static void main(String[] args) {
        File file = new File("itcast/chap21/demo3/in.txt");
        HashMap<String, String> hashMap = new HashMap();

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter("itcast/chap21/demo3/out.txt"));){
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("[.]");
                hashMap.put(split[0], split[1]);
            }
            System.out.println(hashMap);
            for (int i = 0; i < hashMap.size(); i++) {
                String key = i+1 + "";
                String v = hashMap.get(key);
                bw.write(key + "." + v);
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
