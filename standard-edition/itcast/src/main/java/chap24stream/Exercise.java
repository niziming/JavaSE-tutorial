package chap24stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Exercise {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        Stream<String> stream = one.stream();
        Stream<String> stream1 = two.stream();
        Stream<String> fil1 = stream.filter(s -> s.length() == 3).limit(3);
        Stream<String> fil2 = stream1.filter(s -> s.startsWith("张")).skip(2);
        Stream<String> concat = Stream.concat(fil1, fil2);
        concat.forEach(System.out::print);
        method();
    }

    public static void method() {

    }

}
