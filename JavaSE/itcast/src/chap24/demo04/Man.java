package chap24.demo04;

public class Man extends Human {
    @Override
    public void sayHello() {
        System.out.println("大家好我是man");
    }
    public void method(Greetable g){
        g.greet();
    }
    public void show(){
        method(() -> {
            new Human().sayHello();
        });
        method(() -> new Human().sayHello());
        method(() -> super.sayHello());
        method(super::sayHello);
    }
}
