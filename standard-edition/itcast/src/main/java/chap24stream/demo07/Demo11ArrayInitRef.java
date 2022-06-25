package chap24stream.demo07;

public class Demo11ArrayInitRef {
    public static int[] intArray(int length, ArrayBuilder arrauBuilder){
        return arrauBuilder.buildArray(length);
    }

    public static void main(String[] args) {
        int[] ints = intArray(10, length -> new int[length]);
        int[] ints1 = intArray(10, int[]::new);
    }
}
