package cn.zm.basis;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 集合demo
 */
public class CollectionDemo {

  /**
   * a static method with a return type of List
   *
   * @return
   */
  public static List<String> getList() {
    List<String> list = new ArrayList<String>();
    list.add("a");
    list.add("b");
    list.add("c");
    return list;
  }

  /**
   * a static method with a return type of Vector
   *
   * @return
   */
  public static Vector<Object> getVector() {
    final Vector<Object> objects = new Vector<>();
    objects.add("d");
    objects.add("e");
    objects.add("f");
    return objects;
  }

  /**
   * 一个静态方法, 返回一个Set
   */
  public static Set getSet() {
    Set<Object> objects = new HashSet<>();
    objects.add("v");
    objects.add("n");
    objects.add("m");
    objects.add(null);
    return objects;
  }

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

  public static void main(String[] args) {

    Integer temp;

    ArrayList<Integer> array = getArray();

    System.out.println(array);

    for (int i = 0; i < array.size(); i++) {
      if (i < array.size() - i - 1) {
        temp = array.get(i);
        array.set(i, array.get(array.size() - i - 1));
        array.set(array.size() - i - 1, temp);
      }
    }

    System.out.println(array);

    Collections.reverse(array);

    System.out.println(array);

    System.out.println(getList());
    System.out.println(getVector());
    System.out.println(getSet());
  }
}
