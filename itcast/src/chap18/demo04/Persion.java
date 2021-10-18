package chap18.demo04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Persion {
    String name;
    int age;

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        // 传统写法
        Persion[] array = {new Persion("z", 20), new Persion("m", 18), new Persion("h", 21)};

        Comparator<Persion> comparator = new Comparator<>() {
            @Override
            public int compare(Persion o1, Persion o2) {
                return o1.age - o2.age;
            }
        };

        Arrays.sort(array, comparator);
        System.out.println(Arrays.toString(array));

        // lambda
        Arrays.sort(array, (o1, o2) -> o2.age - o1.age);
        System.out.println(Arrays.toString(array));
    }
}
