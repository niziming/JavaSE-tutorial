package chap15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CountLetter {
    public static void main(String[] args) {
        findChar(enter());
    }

    private static void findChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hashMap.containsKey(c)){
                hashMap.put(c, 1);
            } else {
                Integer o = hashMap.get(c);
                hashMap.put(c, ++o);
            }
        }
        System.out.println(hashMap);
    }

    public static String enter(){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        System.out.println(in);
        return in;
    }
}
