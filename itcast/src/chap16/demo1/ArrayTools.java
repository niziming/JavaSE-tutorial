package chap16.demo1;

public class ArrayTools {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3};
        Integer i = getEle(ints, 3);
        System.out.println(i);
    }

    private static <E> E getEle(E[] e, int index) {
        try {
            return e[index];
        } catch (Exception ex) {
            System.out.print("ex.printStackTrace()");
            ex.printStackTrace();
            System.out.print("ex.toString()");
            ex.toString();
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("不管怎么样我都会执行");
        }
        return e[index];
    }
}
