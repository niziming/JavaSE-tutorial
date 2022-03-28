package cn.zm.basis;

import java.util.*;

/**
 * 集合demo
 *
 */
public class CollectionDemo {

  /**
   * a static method with a return type of List
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
   *   一个静态方法, 返回一个Set
  */
  public static Set getSet() {
    Set<Object> objects = new HashSet<>();
    objects.add("v");
    objects.add("n");
    objects.add("m");
    objects.add(null);
    return objects;
  }

  public static void main(String[] args) {
    System.out.println(getList());
    System.out.println(getVector());
    System.out.println(getSet());
  }
}
