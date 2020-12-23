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
        // 比较运算符
        System.out.println(1==1);
        Boolean b1 = 1==1;
        System.out.println(b1);
    }
    private static String getType(Object o) {
        return o.getClass().toString();
    }
}
