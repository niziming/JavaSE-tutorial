package atguigu.chap12generic.generic;

/**
 * 自定义泛型接口
 * @param <T>
 * @param <E>
 */
public interface Comparator<T, E, R> {
    // public static final T MAX_VALUE = 100; // 接口中的泛型字母不可使用在全局常量中
    public static final int MAX_VALUE = 100;
    void compare(E e);
    E compare();
    public abstract R compare1(T t, E e);
}
