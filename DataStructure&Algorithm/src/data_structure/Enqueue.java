package data_structure;


/**
 * �����ȳ������ݽṹ
 * �� FIFO ���ݽṹ�У������ȴ�����ӵ������еĵ�һ��Ԫ�ء�
 * <p>
 * ����ͼ��ʾ�������ǵ��͵� FIFO ���ݽṹ�����루insert������Ҳ������ӣ�enqueue������Ԫ��ʼ�ձ�����ڶ��е�ĩβ�� ɾ����delete������Ҳ����Ϊ���ӣ�dequeue)�� ��ֻ���Ƴ���һ��Ԫ�ء�
 */
public class Enqueue<E> {
  Node head; // ͷ
  Node tail; // β��
  int size; // ���еĴ�С

  /**
   * ���
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
   * ���
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
      System.out.println(temp);
      temp = temp.next;
    }
    System.out.println(temp);
  }


  /**
   * �ڵ�
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
    Enqueue<Integer> enqueue = new Enqueue<>();
    enqueue.put(1);
    enqueue.put(2);
    enqueue.put(3);
    enqueue.put(4);
    enqueue.put(5);
    enqueue.print();
    System.out.println(enqueue.pop());
    System.out.println(enqueue.pop());
    System.out.println(enqueue.pop());
    System.out.println(enqueue.pop());
    System.out.println(enqueue.pop());
  }
}
