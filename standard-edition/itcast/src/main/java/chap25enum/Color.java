package chap25enum;

import java.util.Arrays;

public enum Color {
    RED, BLUE, GREEN, BLACK;
}
class Test {
    public static void main(String[] args) {
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));

        compare(Color.valueOf("GREEN"));
        int black = Color.valueOf("BLACK").ordinal();
        System.out.println("寻找成员的索引位置" + black);
    }
    public static void compare (Color c) {
        for (int i = 0; i < Color.values().length; i++) {
            System.out.println(c + "与" + Color.values()[i] +
                    "的比较结果是: " + c.compareTo(Color.values()[i]));
        }
    }
}
