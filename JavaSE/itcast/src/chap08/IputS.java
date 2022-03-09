package chap08;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IputS {
    public static void main(String[] args) {
        ClassName c = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("aaa.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            c =  (ClassName) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(c.list);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("没找到对象");
            e.printStackTrace();
            return;
        }

    }
}
