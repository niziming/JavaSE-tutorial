package data_structure.tree;

import lombok.Data;

/**
 * Array realize BinaryTree
 * @author 十渊
 */
@Data
public class ArrayBinaryTree {
  private Object[] tree = new Object[10];
  Integer index = 1;

  public void insert (Object data){

    Object root = tree[index];
    if (root == null) {
      tree[index] = data;
      return;
    }

    while (true) {
      if (tree[index*2] == null) {
        tree[index*2] = data;
        return;
      } else if (tree[index*2+1] == null){
        tree[index*2+1] = data;
        return;
      }
      index++;
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

  }

}
