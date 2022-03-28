package data_structure.linked;

/**
 * 链表
 */
public class Linked {

  /**
   * 单链表
   */
  static class SinglyListNode{
    int value;

    SinglyListNode next;
    SinglyListNode head;
    SinglyListNode prev;

    public SinglyListNode(int value){
      this.value = value;
    }

    public void add(Integer value){
      while (next != null){
        head = next.next;
      }
      next = new SinglyListNode(value);
    }

    @Override
    public String toString() {
      return "SinglyListNode{" +
        "value=" + value +
        ", next=" + next +
        '}';
    }
  }

  public static void main(String[] args) {
    SinglyListNode singlyListNode = new SinglyListNode(21);
    singlyListNode.add(22);
    singlyListNode.add(23);
    singlyListNode.add(24);
    singlyListNode.add(25);
    System.out.println(singlyListNode);
  }
}
