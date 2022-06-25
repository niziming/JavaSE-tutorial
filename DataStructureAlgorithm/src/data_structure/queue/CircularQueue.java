package data_structure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 *
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 *
 * 你的实现应该支持如下操作：
 *
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
public class CircularQueue {
  private int[] queue;
  private int size;
  private int head;
  private int tail;


  public CircularQueue(int k) {
    this.size = k;
    this.head = -1;
    this.tail = -1;
    this.queue = new int[k];
  }

  /**
   * 入队 向循环队列插入一个元素。如果成功插入则返回真。
   */
  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    if (isEmpty()) {
      head = 0;
      tail = 0;
    } else {
      tail = (tail + 1) % size;
    }
    queue[tail] = value;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }
    if (head == tail) {
      head = -1;
      tail = -1;
    } else {
      head = (head + 1) % size;
    }
    return true;
  }

  /**
   * 返回队首元素。如果队列为空，返回 -1 。
   * @return
   */
  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return this.queue[head];
  }

  /**
   * 返回队尾元素。如果队列为空，返回 -1 。
   * @return
   */
  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return this.queue[tail];
  }

  /**
   * 检查循环队列是否为空。
   * @return
   */
  public boolean isEmpty() {
    return head == -1;
  }

  /**
   * 检查循环队列是否已满。
   */
  public boolean isFull() {
    return ((this.tail + 1) % size) == head;
  }

}
