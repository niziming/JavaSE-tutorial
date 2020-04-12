package itcast.day09;

import itcast.day08.Phone;

public class NewPhone extends Phone {
    @Override
    public void showNum() {
        // 调用父类的showNum
        // super.showNum();
        System.out.println("NewPhone show Num");
    }

    @Override
    public int callNum(int number) {
        System.out.println(number);
        return number;
    }
}
