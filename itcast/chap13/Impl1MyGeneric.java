package itcast.day13;

public class Impl1MyGeneric<E> implements MyGeneric<E> {
    E e;
    @Override
    public void add(E e) {
        // 省略...
        this.e = e;
    }

    @Override
    public E getE() {
        return this.e;
    }
}
