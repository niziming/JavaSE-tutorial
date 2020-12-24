package itcast.chap09.demo2;

public class Teacher extends Employee{
    void printName () {
        System.out.println("name=" + name);
    }

    @Override
    void work() {
        super.work();
        System.out.println("子类老师在工作");
    }
}
