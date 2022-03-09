package chap09.demo5;

public class Iphone extends Phone {
    @Override
    public void sendMessage() {
        // super.sendMessage();
        System.out.println("iphone发消息");
    }

    @Override
    public void call() {
        // super.call();
        System.out.println("iphone打电话");
    }

    @Override
    public void showNum() {
        // super.showNum();
        System.out.println("iphone显示来单电");
    }

    // 1. 子类方法覆盖父类方法，必须要保证权限大于等于父类权限。
    // 2. 子类方法覆盖父类方法，返回值类型、函数名和参数列表都要一模一样。
    // @Override
    // public void test(String Num){
    //     System.out.println("来电显示号码");
    // }
}
