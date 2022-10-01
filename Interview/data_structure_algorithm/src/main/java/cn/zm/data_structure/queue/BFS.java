package cn.zm.data_structure.queue;

import cn.zm.data_structure.queue.Queue.Node;

import java.util.Objects;

/**
 * 广度优先搜索
 */
public class BFS {

  /**
   * Return the length of the shortest path between root and target node.
   */
  int bfs(Node root, Node target) {
    Queue<Queue.Node> queue = null;  // store all nodes which are waiting to be processed
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    // add root to queue;
    queue.put(root);

    // BFS
    // queue is not empty

    while (Objects.nonNull(queue)) {
      step = step + 1;

      // iterate the nodes which are already in the queue
      int size = queue.size();

      for (int i = 0; i < size; ++i) {
        // Node cur = the first node in queue;
        Node cur = queue.pop();

        // return step if cur is target;
        if (Objects.equals(cur, target)) {
          return step;
        }


        // for (Node next : the neighbors of cur) {
        //   add next to queue;
        // }
        // remove the first node from queue;

      }
    }
    return -1;          // there is no path from root to target
  }


}
