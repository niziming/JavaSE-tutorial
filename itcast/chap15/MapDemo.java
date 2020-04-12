package itcast.day15;

import itcast.day14.Student;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int value = 10;
        String key = "key";
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        hashMap.put(key, ++value);
        hashMap.put(key1, ++value);
        hashMap.put(key2, ++value);
        hashMap.put(key3, ++value);
        hashMap.put(key4, ++value);
        hashMap.put(key5, ++value);
        // System.out.println(hashMap);
        // hashMap.remove("key");
        // Integer key11 = hashMap.get("key1");
        // System.out.println(key11);
        // System.out.println(hashMap);
        // Set<String> strings = hashMap.keySet();
        // System.out.println(strings);
        // Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        // for (Map.Entry<String, Integer> s : entries) {
        //     System.out.println(s);
        // }
        // System.out.println(entries);
        // System.out.println(hashMap);
        // Set<String> strings1 = hashMap.keySet();
        // for (String s : strings1) {
        //     Integer integer = hashMap.get(s);
        //     if (integer == 12) System.out.println(true);
        //     if (integer != 15) System.out.println(false);
        // }
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> me: entries) {
            String keyE = me.getKey();
            Integer valueE = me.getValue();
            System.out.println("key: " + keyE + ", value: " + valueE);
        }
        Map<Student, String> maps = new HashMap<>();
        maps.put(new Student("小明", 12), "成都");
        maps.put(new Student("小黄", 14), "上海");
        maps.put(new Student("秦始皇", 14), "西安");
        Set<Map.Entry<Student, String>> entries1 = maps.entrySet();
        for (Map.Entry<Student, String> entry : entries1){
            Student ek = entry.getKey();
            String zip = entry.getValue();
            System.out.println(ek.toString() + " in " + zip);
        }
    }
}
