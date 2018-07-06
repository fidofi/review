package com.fidofi.review.algorithm.tree;

/** @Auther: fido @Date: 2018/7/6 21:02 @Description:遍历二叉树 */
public class TravelTree {

  /**
   * 中序遍历二叉树
   *
   * @param treeNode
   */
  public static void travelMid(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    travelMid(treeNode.getLeft());
    System.out.println(treeNode.getValue());
    travelMid(treeNode.getRight());
  }

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode();
    treeNode1.setValue(3);
    TreeNode treeNode2 = new TreeNode();
    treeNode2.setValue(1);
    TreeNode treeNode3 = new TreeNode();
    treeNode3.setValue(2);
    TreeNode treeNode4 = new TreeNode();
    treeNode4.setValue(4);
    TreeNode treeNode5 = new TreeNode();
    treeNode5.setValue(5);
    treeNode1.setLeft(treeNode2);
    treeNode2.setRight(treeNode3);
    treeNode1.setRight(treeNode4);
    treeNode4.setRight(treeNode5);
    travelMid(treeNode1);
  }
}
