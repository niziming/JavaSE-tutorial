package chap24stream;

import java.util.*;

public class Demo01ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        // for (String name:list) {
        //     System.out.println(name);
        // }
        // Iterator<String> iterator = list.iterator();
        // while (iterator.hasNext())
        //     System.out.println(iterator.next());
        // ArrayList<String> method = method(list);
        // System.out.println(method);
        method1(list);
    }

    public static ArrayList<String> method(List<String> list) {
        ArrayList<String> strings = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张"))
                strings.add(name);
        }
        return strings;
    }
    public static void method1 (List<String> list){
        list.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::print);
        // System.out.println(list);
    }

}
