package com.fidofi.review.algorithm.sort;

/** @Auther: fido @Date: 2018/7/8 12:17 @Description: 冒泡排序 */
public class BubbleSort implements Sort {

  @Override
  public int[] sort(int[] target) {
    /** 用于改进冒泡排序，因为如果已经有序，冒泡排序依然会两两比较，当数组并没有发生交换情况，说明数组已经有序，可以直接返回 */
    boolean flag = false;
    for (int i = target.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (target[j] > target[j + 1]) {
          ArrayUtils.swap(target, j, j + 1);
          flag = true;
        }
      }
      if (!flag) {
        return target;
      }
    }
    return target;
  }
}
