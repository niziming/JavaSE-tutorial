package chap24.demo;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo01PrintSimple {
    public static void main(String[] args) {
        printString(str -> System.out.print(str));
        Demo01PrintSimple demo01PrintSimple = new Demo01PrintSimple();
        ArrayList<Object> objects = new ArrayList<>();
        Stream<Object> stream = objects.stream();
        printString(System.out::print);
    }

    public static void printString(Printable data) {
        data.printStr("Helllo, world");
    }

}
