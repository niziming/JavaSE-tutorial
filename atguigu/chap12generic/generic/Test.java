package atguigu.chap12generic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * extends:泛型的上限 <= 一般用于限制操作 不能使用在添加数据上，一般都是用于数据的读取
 *
 * supper:泛型的上限 >= 即父类或自身。一般用于下限操作
 *
 * @author Administrator
 * @param <T>
 */
public class Test <T extends Fruit>{
    public static void main(String[] args) {
        test();
        // test1(new ArrayList<Father>());
        test1(new ArrayList<Fruit>());
        test1(new ArrayList<Apple>());
        test1(new ArrayList<ReadApple>());

        test2(new ArrayList<Apple>());
        test2(new ArrayList<Fruit>());
        // test2(new ArrayList<ReadApple>()); // ReadApple < apple,所以不能放入
    }

    private static void test2(List<? super Apple> list) {

    }

    private static void test1(List<? extends Fruit> list) {


    }

    private static void test() {
        Test fruitTest = new Test<Fruit>();
        Test fruitTest1 = new Test<Apple>();
        Test fruitTest2 = new Test<Pear>();
    }

}
class Fruit {
}
class ReadApple extends Apple{
}
class Apple extends Fruit{
}
class Pear extends Fruit{
}