package itcast.chap09.demo3;

public class Zi extends Fu {
    // 成员变量
    int num2 = 6;
    // 成员变量重名
    // 如果子类父类中出现重名的成员变量，这时的访问是有影响的。代码如下：
    int num = 11;
    void show() {
        // 访问父类中的num，        
        System.out.println("Fu num=" + num); // 继承而来，所以直接访问。        
        // 子父类中出现了同名的成员变量时，在子类中需要访问父类中非私有成员变量时，需要使用 super 关键字，修饰
        // 父类成员变量，类似于之前学过的 this 。
        System.out.println("Fu super.num=" + super.num); // 继承而来，所以直接访问。        
        // 访问子类中的num        
        System.out.println("Zi num=" + num);
        // 访问子类中的num2        
        System.out.println("Zi num2=" + num2);
    }
}
