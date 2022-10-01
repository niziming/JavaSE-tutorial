package cn.zm.data_structure.tree;

import cn.hutool.core.lang.Assert;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BinaryTree
 * @author 十渊
 */
@Data
public class LinkedBinaryTree {

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
    Assert.notNull(this.root, "The root node required non null");

  }

  public void setRoot(Node root) {
    this.root = root;
  }

  public Node getRoot() {
    return root;
  }

  public LinkedBinaryTree(Node root) {
    this.root = root;
    this.root.data = 0;
    this.deep = 0;
  }

  public LinkedBinaryTree() {
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

  // 先序遍历
  public void preOrder (Node root) {
    if (root == null) return;
    System.out.println("root.data = " + root.data);
    preOrder(root.left);
    preOrder(root.right);
  }

  // 中序遍历
  public void inOrder (Node root) {
    if (root == null) return;
    inOrder(root.left);
    System.out.println("root.data = " + root.data);
    inOrder(root.right);
  }

  // 中序遍历
  public void postOrder (Node root) {
    if (root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.println("root.data = " + root.data);
  }

  public static void main(String[] args) {


    LinkedBinaryTree linkedBinaryTree = new LinkedBinaryTree();

    Node node =  new LinkedBinaryTree().new Node(1);
    linkedBinaryTree.insert(node);
    System.out.println("binaryTree = " + linkedBinaryTree);

    Node node1 =  new LinkedBinaryTree().new Node(2);
    linkedBinaryTree.insert(node1);
    System.out.println("binaryTree = " + linkedBinaryTree);

    Node node2 =  new LinkedBinaryTree().new Node(3);
    linkedBinaryTree.insert(node2);
    System.out.println("binaryTree = " + linkedBinaryTree);

    // 先序遍历
    linkedBinaryTree.preOrder(node1);

    System.out.println("中序遍历");
    // 中序遍历
    linkedBinaryTree.inOrder(node1);

    System.out.println("后续遍历");
    // 后续
    linkedBinaryTree.postOrder(node1);

  }
}
