package itcast.chap08;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassName implements Serializable {
    public static int num;
    public static ArrayList<String> list;
    static {
        // 给类变量赋值
        num = 2;
        list = new ArrayList<>();
        // 将元素添加到集和
        list.add("张三");
        list.add("李四");
    }
}
