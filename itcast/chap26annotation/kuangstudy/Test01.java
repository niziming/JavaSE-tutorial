package itcast.chap26annotation.kuangstudy;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Test01 extends Object {
    /**
     * 重写注解
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public static void test() {

    }


    public static void test1() {
        List list = new ArrayList<>();
    }



    public static void main(String[] args) {
        test();
    }
}
