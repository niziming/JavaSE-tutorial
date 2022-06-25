package data_structure.tree;

import cn.hutool.core.lang.Assert;
import lombok.Data;

/**
 * Array realize BinaryTree
 * @author 十渊
 */
@Data
public class ArrayBinaryTree {
  private Object[] tree = new Object[10];
  Integer deep = 1;

  public void insert (Object data){

    Object root = tree[deep];
    if (root == null) {
      tree[deep] = data;
      return;
    }

    while (true) {
      int leftLeaf = deep * 2;
      Assert.isTrue(leftLeaf <= tree.length-1, "越界了-" + leftLeaf);
      if (tree[leftLeaf] == null) {
        tree[leftLeaf] = data;
        return;
      }

      int rightLeaf = leftLeaf + 1;
      Assert.isTrue(rightLeaf <= tree.length-1, "越界了-" + rightLeaf);
      if (tree[rightLeaf] == null){
        tree[rightLeaf] = data;
        return;
      }
      deep++;
    }

  }

  public static void main(String[] args) {
    ArrayBinaryTree binaryTree = new ArrayBinaryTree();
    binaryTree.insert('A');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('B');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('C');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('D');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('E');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('F');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('G');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('H');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('I');
    System.out.println("binaryTree = " + binaryTree);
    binaryTree.insert('J');
    System.out.println("binaryTree = " + binaryTree);

  }

}
