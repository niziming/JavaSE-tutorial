package chap15;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LHMD {
    public static void main(String[] args) {
        Map<Object, Object> map= new LinkedHashMap<>();
        map.put("邓超","孙俪");
        map.put("李晨","范冰冰");
        map.put("刘德华","朱丽倩");
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry e : entries) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        Map<Object, Object> map1= new HashMap<>();
        map1.put("邓超","孙俪");
        map1.put("1","2");
        map1.put("李晨","范冰冰");
        map1.put("3","4");
        map1.put("刘德华","朱丽倩");
        map1.put("5","6");
        Set<Map.Entry<Object, Object>> entries1 = map1.entrySet();
        for (Map.Entry e : entries1) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
