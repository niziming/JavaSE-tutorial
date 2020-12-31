package itcast.chap14.list;

import java.util.LinkedList;

public class LinkedListUsed {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("hello");
        linkedList.addFirst("world");
        linkedList.addLast("mm1");
        linkedList.addLast("mm2");
        System.out.println(linkedList);
        linkedList.pop();
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.push(new ListUsed());
        System.out.println(linkedList);
        System.out.println(linkedList.isEmpty());
    }
}
