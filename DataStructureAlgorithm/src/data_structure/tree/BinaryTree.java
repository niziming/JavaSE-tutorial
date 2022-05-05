package data_structure.tree;

import cn.hutool.core.lang.Assert;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 二叉树
 * @author DELL
 */
@Data
public class BinaryTree {
  // 根节点
  private Node root;
  // 深度
  private Integer deep = 1;


  /**
   * 插入节点
   * data比当前current节点的data小的在其左子树，大的在右子树。通过不断更新current，
   * 最终节点会被在正确的位置插入。
   */
  public void insert(Node node) {
    if (this.root == null){
      this.root = node;
      return;
    }

    // 保存当前节点
    Node current = root;

    while (true) {
      // 小于当前
      if (node.getData() < current.getData()) {
        if (current.getLeft() == null) {
          current.setLeft(node);
          deep++;
          return;
        } else { // 否则当前节点切换成左边
          current = current.getLeft();
        }
      }
      // 大于当前
      else {
        if (current.getRight() == null) {
          current.setRight(node);
          deep++;
          return;
        } else {
          current = current.getRight();
        }
      }
    }

  }


  public void frontTraverse() {
    Assert.notNull(this.root, "The root required not null");

  }

  public void setRoot(Node root) {
    this.root = root;
  }

  public Node getRoot() {
    return root;
  }

  public BinaryTree(Node root) {
    this.root = root;
    this.root.data = 0;
    this.deep = 0;
  }

  public BinaryTree() {
    this.deep = 0;
    this.root = new Node();
    this.root.data = 0;
  }


  // 节点
  @Data
  @NoArgsConstructor
  class Node {
    Integer data;
    Node left;
    Node right;

    public Node(Integer data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    Node node =  new BinaryTree().new Node(1);
    binaryTree.insert(node);
    System.out.println("binaryTree = " + binaryTree);
  }
}
