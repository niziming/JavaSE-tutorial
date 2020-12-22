package itcast.chap02;

public class DataTpyeTransformation {
    public static void main(String[] args) {
        int i = 1;
        byte b = 2;
        System.out.println(getType(i));
        System.out.println((Object)i);
        int i1 = (int)1.5;
        System.out.println(i1);
        System.out.println(getType(1.5));

        short s = 1;
        s = (short)(s+60000);
        System.out.println(s);
    }
    private static String getType(Object o) {
        return o.getClass().toString();
    }
}
