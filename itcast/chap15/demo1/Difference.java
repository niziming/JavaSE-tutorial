package itcast.chap15.demo1;


import java.util.*;

public class Difference {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("hekko", new Student("ziming", 15));
        map.put("hekko", new Student("ziming", 15));
        map.put("hekko1", new Student("ziming", 15));
        map.put("hekko2", new Student("ziming", 15));
        map.put("hekko3", new Student("ziming", 15));

        System.out.println(map);
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap();

        linkedHashMap.put("String", new Student("zaiming", 29));
        linkedHashMap.put("String", new Student("zaiming", 29));
        linkedHashMap.put("String1", new Student("zaiming", 29));
        linkedHashMap.put("String2", new Student("zaiming", 29));
        linkedHashMap.put("String3", new Student("zaiming", 29));
        linkedHashMap.remove("String");
        System.out.println(linkedHashMap);

        System.out.println(linkedHashMap.keySet());
        System.out.println(linkedHashMap.entrySet());
        System.out.println(linkedHashMap.entrySet());
        Set<Map.Entry<String, Object>> entries = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        Map.Entry<String, Object> next = iterator.next();

        System.out.println(next.getKey());
        System.out.println(next.getValue());

        HashMap<String, Student> hashMap = new HashMap();
        hashMap.put("胡歌", new Student("huge", 123));
        hashMap.put("霍建华", new Student("hjh", 123));

        Set<Map.Entry<String, Student>> entries1 = hashMap.entrySet();

        for (Map.Entry<String, Student> entry : entries1){
            System.out.println(entry);
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + ": " + value);
        }

    }
}
