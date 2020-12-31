package itcast.chap15.demo3;

import java.util.ArrayList;
import java.util.Collections;

public class demo1 {
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        Collections.addAll(objects, new Integer[]{10, 20});
        System.out.println(objects);


    }
}
