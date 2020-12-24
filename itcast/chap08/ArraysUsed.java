package itcast.chap08;

import itcast.chap08.ClassName;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// java.util.Arrays 此类包含用来操作数组的各种方法，比如排序和搜索等。其所有方法均为静态方法，调用起来
//         非常简单。
public class ArraysUsed {
    public static void main(String[] args) throws IOException {
        // 定义int 数组
        // int[] arr = {2, 34, 35, 4, 657, 8, 69, 9};
        // System.out.println(arr);
        // String s = Arrays.toString(arr);
        // System.out.println(s);
        // Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        String line = "ysKUreaytWTRHsgFdSAoidq";
        char[] chars = line.toCharArray();
        System.out.println(Arrays.toString(chars));
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));

        // ClassName className = new ClassName();
        // FileOutputStream fileOutputStream = new FileOutputStream("aaa.txt");
        // ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        // out.writeObject(className);
        // out.close();
        // fileOutputStream.close();
        // System.out.println("保存");
    }
}
