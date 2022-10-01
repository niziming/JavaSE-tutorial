package cn.zm.data_structure.queue;


/**
 * 队列
 * 先入先出的数据结构
 * 在 FIFO 数据结构中，将首先处理添加到队列中的第一个元素。
 * <p>
 * 如上图所示，队列是典型的 FIFO 数据结构。插入（insert）操作也称作入队（enqueue），新元素始终被添加在队列的末尾。 删除（delete）操作也被称为出队（dequeue)。 你只能移除第一个元素。
 */
public class Queue<E> {
  Node head; // 头
  Node tail; // 尾部
  int size; // 队列的大小

  /**
   * 入队
   */
  public void put(E e) {
    Node<E> node = new Node(e);
    if (head == null) {
      head = node;
      tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }


  /**
   * 长度
   */
  public int size() {
    return size;
  }

  /**
   * 入队
   */
  public E pop() {
    if (size == 0) {
      return null;
    }
    Node<E> node = head;
    head = head.next;
    size--;
    return node.e;
  }

  public void print(){
    Node temp = head;
    while(temp.next != null){
      System.out.print(temp.toString() + ',');
      temp = temp.next;
    }
    System.out.println(temp);
  }

  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }


  /**
   * 节点
   *
   * @param <E>
   */
  class Node<E> {
    E e;
    Node next;

    public Node(E e) {
      this.e = e;
    }

    @Override
    public String toString() {
      return e.toString();
    }
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>();
    queue.put(1);
    queue.put(2);
    queue.put(3);
    queue.put(4);
    queue.put(5);
    queue.print();
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
  }
}
