package chap13;

public class MyGenericClass<E> {
    private E e;

    public void setE(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    /**
     * 含有泛型的方法
     * @param e
     * @param <E>
     * @return
     */
    public <E> E show1 (E e) {
        return e;
    }
    /**
     * 含有泛型的方法
     * @param <E>
     */
    public <E> void show (E e) {
        System.out.println(e.getClass());
    }
}
