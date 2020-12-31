package itcast.chap15.demo2;

import com.sun.jdi.event.StepEvent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap();
        map.put("邓超","孙俪");
        map.put("李晨","范冰冰");
        map.put("刘德华","朱丽倩");
        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry entry : entries){
            System.out.println(entry);

        }
    }
}
