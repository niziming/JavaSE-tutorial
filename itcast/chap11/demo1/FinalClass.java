package itcast.chap11.demo1;


// 学习了继承后，我们知道，子类可以在父类的基础上改写父类内容，比如，方法重写。那么我们能不能随意的继承
// API中提供的类，改写其内容呢？显然这是不合适的。为了避免这种随意改写的情况，Java提供了 final 关键字，
// 用于修饰不可改变内容。
// final ： 不可改变。可以用于修饰类、方法和变量。
// 类：被修饰的类，不能被继承。
// 方法：被修饰的方法，不能被重写。
// 变量：被修饰的变量，不能被重新赋值。
final public class FinalClass {
    // 修饰方法
    // 查询 API发现像 public final class String 、 public final class Math 、 public final class Scanner
    // 等，很多我们学习过的类，都是被final修饰的，目的就是供我们使用，而不让我们所以改变其内容。
    final void method () {
        System.out.println("final method");
    }

    public static void main(String[] args) {
        final int a = 10;
        // a = 20;// 报错,不可重新赋值
        System.out.println(a);

        // final int c = 10;
        // for (int i = 0; i < 10; i++) {
        //     c = i;
        //     System.out.println(c);
        // }

        // for (int i = 0; i < 10; i++) {
        //     final int c = i;
        //     System.out.println(c);
        // }

        // final FinalClass finalClass = new FinalClass();
        FinalClass finalClass = new FinalClass();
        finalClass.method();
        finalClass = null;
        System.out.println(finalClass);
    }
}

