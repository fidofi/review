package com.fidofi.review.algorithm.tree;

import lombok.Data;
import lombok.ToString;

/** @Auther: fido @Date: 2018/7/6 20:59 @Description: */
@ToString
@Data
public class TreeNode {
  private TreeNode left;
  private TreeNode right;
  private Integer value;
}
