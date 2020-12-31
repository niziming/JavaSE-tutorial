package itcast.chap13.demo2;

import java.util.ArrayList;

public class GenericDemo {
    public static void main(String[] args) {
        ArrayList objects = new ArrayList();
        objects.add("abc");
        objects.add(1);
        for (int i = 0; i < objects.size(); i++) {
            System.out.println(objects.get(i).getClass().getName());
        }
        System.out.println(objects);
    }
}
