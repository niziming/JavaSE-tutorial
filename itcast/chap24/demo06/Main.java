package itcast.day24.demo06;

public class Main {
    public static void main(String[] args) {
        method("你好", name -> new Person(name));
        method("我好", Person::new);
    }

    public static void method(String name, PersonBuilder p) {
        System.out.println(p.buildPerson(name).getName());
    }

}
