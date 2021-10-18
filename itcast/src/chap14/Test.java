package chap14;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> objects = new ArrayList<>();
        objects.add(new Student("rose", 18));
        objects.add(new Student("jack",16));
        objects.add(new Student("abc",17));
        objects.add(new Student("mark",16));
        Collections.sort(objects);
        System.out.println(objects);
    }
}
