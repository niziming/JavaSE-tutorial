package itcast.chap18.demo05;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Person[] person = {
            new Person("古力娜扎", 19),
            new Person("迪丽热巴", 18),
            new Person("马尔扎哈", 20)
        };
        Arrays.sort(person, (Person o1, Person o2) -> o1.age - o2.age);
        System.out.println(Arrays.toString(person));
    }
}
