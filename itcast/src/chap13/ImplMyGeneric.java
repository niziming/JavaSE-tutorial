package chap13;

/*
 * 定义类时确定泛型类型
 */
public class ImplMyGeneric implements MyGeneric<String> {
    @Override
    public void add(String o) {
        // 省略...
    }

    @Override
    public String getE() {
        return null;
    }
}
