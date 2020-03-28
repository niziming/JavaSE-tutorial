package itcast.day13;

public class GenericClassDemo {
    public static void main(String[] args) {
        MyGenericClass my = new MyGenericClass<>();
        my.show("S");
        my.show(123);
        my.show(12.45);
    }

    public static void testGeneric () {
        MyGenericClass<String> my = new MyGenericClass<>();
        my.setE("你好");
        String e = my.getE();
        System.out.println(e);
        MyGenericClass<Integer> myInt = new MyGenericClass<>();
        myInt.setE(123);
        int myInt1 = myInt.getE();
        System.out.println(myInt1);
    }
}
