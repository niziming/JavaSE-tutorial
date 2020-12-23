package itcast.chap08;

public class Phone {
    int number;
    public void sendMsg () {
        System.out.println("Phone's send msg");
    }
    public void call () {
        System.out.println("Phone's call");
    }
    public void showNum () {
        System.out.println("Phone's show number");
    }
    public int callNum (int number) {
        System.out.println("callNum" + number);
        return number;
    }
}
