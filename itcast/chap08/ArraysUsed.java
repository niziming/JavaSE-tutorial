package itcast.chap08;

import itcast.chap08.ClassName;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ArraysUsed {
    public static void main(String[] args) throws IOException {
        ClassName className = new ClassName();
        FileOutputStream fileOutputStream = new FileOutputStream("aaa.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(className);
        out.close();
        fileOutputStream.close();
        System.out.println("保存");
    }
}
