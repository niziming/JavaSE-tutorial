package chap20.demo7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PC {
    public static void main(String[] args) {
        System.out.println(System.getProperties());
        Properties properties = new Properties();
        properties.setProperty("name", "ziming");
        properties.setProperty("sex", "男");
        System.out.println(properties);

        // Properties pro = System.getProperties();
        Properties pro = new Properties();
        Set<String> strings = pro.stringPropertyNames();
        for (String s : strings) System.out.println(s + ": " + pro.getProperty(s));

        // 与流相关的方法
        try (FileInputStream fs = new FileInputStream("itcast/chap20/demo7/properties.txt");){
            // 加载文本中信息到属性集
            pro.load(fs);
            Set<String> strings1 = pro.stringPropertyNames();
            for (String s : strings1) System.out.println(s + " --- " + pro.getProperty(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
