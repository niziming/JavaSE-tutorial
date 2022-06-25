package chap24stream.demo05;

public class Husband {
    public void marry(Richable lambda){
        lambda.buy();
    }
    public void beHappy(){
        marry(this::buyHouse);
    }

    public void buyHouse(){
        System.out.println("买了套房子");
    }
    public static void main(String[] args) {
        new Husband().beHappy();
    }
}
