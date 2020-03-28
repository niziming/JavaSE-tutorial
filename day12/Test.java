package day12;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Person person1 = new Person();
        person.setAge(18);
        person.setName("Jermaine");
        person1.setAge(18);
        person1.setName("Jermaine");
        System.out.println(person);
        Person p1 = person;
        System.out.println(p1.equals(person1));
    }
}
