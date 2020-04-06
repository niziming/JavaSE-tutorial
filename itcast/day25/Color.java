package itcast.day25;

import java.util.Arrays;

public enum Color {
    RED, BLUE, GREEN, BLACK;
}
class Main {
    public static void main(String[] args) {
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));
    }
}
