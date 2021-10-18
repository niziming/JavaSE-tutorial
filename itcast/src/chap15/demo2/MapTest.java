package chap15.demo2;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Character, Integer> hello = findchar("hello");
        System.out.println(hello);
    }

    public static HashMap<Character, Integer> findchar (String line){
        char[] chars = line.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for (char c : chars) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                Integer integer = map.get(c);
                map.put(c, ++integer);
            }
        }
        return map;
    }
}
