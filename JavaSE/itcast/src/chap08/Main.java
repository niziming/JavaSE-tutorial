package chap08;

import itcast.chap05.DefinitionArray;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 内存中只有一个"abc"对象被创建，同时被s1和s2共享。
        // String s1 = "abc";
        // String s2 = "abc";
        // System.out.println(s1);
        // System.out.println(s1.equals(s2));

        // 内存中有"abc"，"abcd"两个对象，s1从指向"abc"，改变指向，指向了"abcd"。
        // s1 += 'd';
        // System.out.println(s1);
        // System.out.println(s1.equals(s2));

        // 3. "abc" 等效于 char[] data={ 'a' , 'b' , 'c' } 。
        // 例如：
        String str = "abc";
        // 相当于：
        // char data[] = {'a', 'b', 'c'};
        // String str1 = new String(data);
        // System.out.println(str);
        // System.out.println(str1);
        // System.out.println(str1 == str); // 比较地址值
        // System.out.println(str1.equals(str)); // 比较值
        // // String底层是靠字符数组实现的。
        // System.out.println(new String(new byte[]{97, 98}));

        // 获取功能的方法
        // System.out.println(str.length());
        // str.concat("def");
        // System.out.println(str);
        // System.out.println(str.charAt(2));
        // System.out.println(str.indexOf("b"));
        // System.out.println(str.isEmpty());
        // System.out.println(str.substring(1));
        // System.out.println(str.substring(1,2));

        // 转换功能的方法
        char[] chars = str.toCharArray();
        byte[] bytes = str.getBytes();
        String a = str.replace("a", "&");
        System.out.println(str.replace("a", "&"));
        System.out.println(Arrays.toString(str.split("")));
        // KeyWords keyWords = new KeyWords();
        // KeyWords keyWords1 = new KeyWords();
        // KeyWords keyWords2 = new KeyWords();
        // System.out.println(keyWords);
        // ClassName cn = new ClassName();
        // System.out.println(cn.num);
        // System.out.println(cn.list);
        // System.out.println(ClassName.num);
        // System.out.println(ClassName.list);
    }
}
