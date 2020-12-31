package itcast.chap13.demo5;

// 修饰符 interface接口名<代表泛型的变量> {  }
public interface GenericInterface <E> {
    void add (E e);
    E getE(E e);
}
