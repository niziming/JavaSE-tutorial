package itcast.chap13;

public class Main {
    public static void main(String[] args) {
        Impl1MyGeneric<String> imp = new Impl1MyGeneric<>();
        imp.add("你好");
        String e = imp.getE();
        System.out.println(e);
    }
}
