package chap14;

import java.util.LinkedList;

public class LinkedListOperation {
    public static void main(String[] args) {
        testLinkedListApi();
    }

    private static void testLinkedListApi() {
        LinkedList<String> linked = new LinkedList();
        // 指定元素插入此列表的开头。
        linked.addFirst("添加头部1");
        linked.addFirst("添加头部2");
        linked.addLast("添加尾部1");
        System.out.println(linked);
        String first = linked.getFirst();
        String last = linked.getLast();
        System.out.println("得到链表中第一个元素: " + first);
        System.out.println("得到链表中最后一个元素: " + last);
        linked.add(0, "我即将被删除");
        linked.add(0, "我即将被删除1");
        linked.add(linked.size(), "我即将被删除2");
        System.out.println(linked);
        boolean del = linked.remove("我即将被删除");
        System.out.println(linked);
        String s1 = linked.removeFirst();
        System.out.println(linked);
        String s = linked.removeLast();
        System.out.println(linked);
        String pop = linked.pop();
        System.out.println("linked: " + linked + " pop: " + pop);
        linked.push("push element in the stack");
        System.out.println(linked);
        String remove = linked.remove();
        System.out.println(linked + "remove 默认删除第一个" + remove);
        while (!linked.isEmpty()) {
            linked.pop();
        }
        System.out.println(linked);
    }
}
