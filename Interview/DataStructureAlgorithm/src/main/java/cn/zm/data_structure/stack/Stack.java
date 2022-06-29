package cn.zm.data_structure.stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 栈：后入先出的数据结构
 * 本章节中，我们将介绍另一种处理顺序后入先出（LIFO），以及相应的数据结构，栈。
 *
 * 完成本章节后，你将：
 *
 * 理解 LIFO 和 栈的定义；
 * 能够用动态数组实现栈；
 * 熟悉内置栈结构；
 * 能够使用栈解决问题。
 */
public class Stack {
  private List<Object> data;

  public Stack() {
    this.data = new ArrayList<>();
  }

  public Integer push(Object e) {
    data.add(e);
    return data.size();
  }
  public Object top() {
    if (check()) return null;
    return data.get(data.size() - 1);

  }

  public Object pop() {
    if (check()) return null;
    Object p = data.get(data.size() - 1);
    data.remove(data.size() - 1);
    return p;
  }

  private boolean check() {
    return data.size() == 0;
  }


  @Override
  public String toString() {
    return "Stack{" +
      "data=" + data +
      '}';
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    System.out.println(stack.top());
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack);
    System.out.println(stack.top());
  }



}
