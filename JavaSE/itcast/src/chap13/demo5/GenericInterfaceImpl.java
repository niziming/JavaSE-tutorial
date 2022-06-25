package chap13.demo5;

public class GenericInterfaceImpl implements GenericInterface<String> {
    @Override
    public void add(String e) {
        System.out.println("override：" + e);
    }

    @Override
    public String getE(String e) {
        System.out.println("get");
        return e;
    }

    public static void main(String[] args) {
        GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
        genericInterface.add("hello");
    }
}
