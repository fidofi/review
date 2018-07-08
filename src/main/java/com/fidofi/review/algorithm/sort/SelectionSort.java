package com.fidofi.review.algorithm.sort;

/** @Auther: fido @Date: 2018/7/8 10:45 @Description: 选择排序 */
public class SelectionSort implements Sort {

  /**
   * 选择排序，需要两个循环，记录当前待排序的位置，以及本次循环中得出最小数的下标，交换两者，待排序位置+1
   *
   * @param target
   * @return
   */
  @Override
  public int[] sort(int[] target) {
    int min = Integer.MAX_VALUE;
    int minIndex = 0;
    for (int i = 0; i < target.length; i++) {
      for (int j = i; j < target.length; j++) {
        if (target[j] < min) {
          min = target[j];
          minIndex = j;
        }
      }
      if (minIndex != i) {
        ArrayUtils.swap(target, i, minIndex);
      }
      min = Integer.MAX_VALUE;
    }
    return target;
  }
}
