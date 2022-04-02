package cn.zm.basis;

import com.sun.jmx.remote.internal.ArrayQueue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 集合
 */
public class CollectionDemo {

  //region list
  static class ListDemo {
    //region ArrayList
    // object [], 线程不安全, 自动扩容, 有序
    public static List<String> getList() {
      List<String> list = new ArrayList<String>();
      list.add("a");
      list.add("b");
      list.add("c");
      return list;
    }
    //endregion

    //region Vector
    public static Vector<Object> getVector() {
      final Vector<Object> objects = new Vector<>();
      objects.add("d");
      objects.add("e");
      objects.add("f");
      return objects;
    }
    //endregion

    //region LinkedList
    public static List<Integer> getLinkedList() {
      List<Integer> lists = new LinkedList<>();

      lists.add(1);
      lists.add(12);
      lists.add(123);

      return lists;
    }
    //endregion
  }
  //endregion

  //region Set
  static class SetDemo {

    //region hashset
    public static Set<String> getSet() {
      Set<String> set = new HashSet<String>();
      set.add("a");
      set.add("b");
      set.add("c");
      set.add("c");
      return set;
    }
    //endregion

    //region LinkedHashSet
    public static Set<String> getLinkedHashSet() {
      Set<String> set = new LinkedHashSet<>();
      set.add("a");
      set.add("b");
      set.add("c");
      return set;
    }
    //endregion

    //region TreeSet
    static Set getTreeSet() {
      Set<String> set = new TreeSet<>();
      set.add("a");
      set.add("b");
      set.add("c");
      return set;
    }
    //endregion
  }
  //endregion

  //region Queue
  static class QueueDemo {

    //region PriorityQueue
    // PriorityQueue: Object[] 数组来实现二叉堆
    static PriorityQueue getPriorityQueue() {
      PriorityQueue<Object> objects = new PriorityQueue<>();
      objects.add("a");
      objects.add("a");
      objects.add("b");
      return objects;
    }
    //endregion

    //region ArrayQueue
    //  Object[] 数组 + 双指针
    static ArrayQueue getArrayQueue() {
      ArrayQueue<String> arrayQueue = new ArrayQueue(10);
      arrayQueue.add("a");
      arrayQueue.add("a");
      arrayQueue.add("b");
      return arrayQueue;
    }
    //endregion

    //region ArrayDeque
    public static Deque getArrayDeque() {
      Deque deque = new ArrayDeque<>();
      deque.add("a");
      deque.add("b");
      return deque;
    }
    //endregion

    public static void main(String[] args) {
      Deque deque = getArrayDeque();
      System.out.println("deque = " + deque);
      deque.addLast("c");
      System.out.println("deque = " + deque);
      deque.addFirst("d");
      System.out.println("deque = " + deque);
      deque.removeFirst();
      System.out.println("deque = " + deque);
      deque.removeLast();
      System.out.println("deque = " + deque);
    }
  }
  //endregion

  //region Map
  static class MapDemo {

    //region HashMap
    static Map getHashMap() {
      Map m = new HashMap();
      m.put("a", "a");
      m.put("a", "a");
      m.put("b", "b");
      return m;
    }
    //endregion

    //region LinkedHashMap
    static Map getLinkedHashMap() {
      Map m = new LinkedHashMap();
      m.put("a", "a");
      m.put("a", "a");
      m.put("b", "b");
      return m;
    }
    //endregion

    //region Hashtable
    static Map getHashtable() {
      Map m = new Hashtable();
      m.put("a", "a");
      m.put("a", "a");
      m.put("b", "b");
      return m;
    }
    //endregion

    //region Hashtable
    static Map getTreeMap() {
      Map m = new TreeMap();
      m.put("a", "a");
      m.put("a", "a");
      m.put("b", "b");
      return m;
    }
    //endregion

    //region ConcurrentHashMap
    public static ConcurrentHashMap<String, String> getConcurrentHashMap () {
      ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
      map.put("a", "a");
      map.put("b", "b");
      map.put("c", "c");
      map.put("d", "d");
      map.put("e", "e");
      map.put("f", "f");
      map.put("g", "g");
      map.put("h", "h");
      map.put("i", "i");
      map.put("j", "j");
      map.put("k", "k");
      map.put("l", "l");
      map.put("m", "m");
      map.put("n", "n");
      map.put("o", "o");
      map.put("p", "p");
      map.put("q", "q");
      map.put("r", "r");
      map.put("s", "s");
      map.put("t", "t");
      map.put("u", "u");
      map.put("v", "v");
      return map;
    }
    //endregion

    public static void main(String[] args) {
      System.out.println("MapDemo.HashMap() = " + MapDemo.getHashMap());
      System.out.println("MapDemo.LinkedHashMap() = " + MapDemo.getLinkedHashMap());
      System.out.println("MapDemo.Hashtable() = " + MapDemo.getHashtable());
      System.out.println("MapDemo.TreeMap() = " + MapDemo.getTreeMap());
      System.out.println("MapDemo.ConcurrentHashMap() = " + MapDemo.getConcurrentHashMap());
    }
  }
  //endregion

  //region reverse
  public static ArrayList<Integer> getArray() {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(-1);
    arrayList.add(3);
    arrayList.add(3);
    arrayList.add(-5);
    arrayList.add(7);
    arrayList.add(4);
    arrayList.add(-9);
    arrayList.add(-7);
    return arrayList;
  }

  static void reverse(ArrayList<Integer> array) {
    Integer temp;
    for (int i = 0; i < array.size(); i++) {
      if (i < array.size() - i - 1) {
        temp = array.get(i);
        array.set(i, array.get(array.size() - i - 1));
        array.set(array.size() - i - 1, temp);
      }
    }
  }
  //endregion

  //region Comparable
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Person implements Comparable {
    private int age;
    private String name;

    @Override
    public int compareTo(Object o) {
      int i = this.age - ((Person) o).age;
      return i == 0 ? 0 : i > 0 ? 1 : -1;
    }

    public static void main(String[] args) {
      Person p1 = new Person(1, "a");
      Person p2 = new Person(2, "b");
      Person p3= new Person(23, "b");
      Person p4 = new Person(24, "b");

      TreeMap<Object, Object> map = new TreeMap<>();
      map.put(p1, "张三");
      map.put(p2, "李四");
      map.put(p3, "王五");
      map.put(p4, "xiaohong");

      Set<Object> objects = map.keySet();
      for (Object o : objects) {
        System.out.println(o + ":" + map.get(o));
      }

      System.out.println(p1.compareTo(p2));
    }
  }
  //endregion

  //region 集合遍历
  public static class IteratorDemo {
    /**
     * 集合遍历
     */
    public static List<Integer> iterator() {
      List<Integer> list = new ArrayList<>();
      for (int i = 1; i <= 10; ++i) {
        list.add(i);
      }
      for (int i = 1; i <= 10; ++i) {
        list.add(i);
      }
      list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
      System.out.println(list); /* [1, 3, 5, 7, 9] */
      return list;
    }

    public static void main(String[] args) {
      List<Integer> iterator = iterator();
      HashSet<Integer> integers = new HashSet<>(iterator);
      System.out.println("integers = " + integers);

    }
  }
  //endregion
}
