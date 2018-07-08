package com.fidofi.review.algorithm.sort;

/** @Auther: fido @Date: 2018/7/8 12:18 @Description:插入排序 */
public class InsertionSort implements Sort {
  @Override
  public int[] sort(int[] target) {
    for (int j = 1; j <= target.length - 1; j++) {
      /** 表示待排序元素 */
      int temp = target[j];
      for (int i = 0; i < j; i++) {
        if (temp < target[i]) {
          /** 待排序元素最终的位置 */
          int n = j;
          while (n != i) {
            target[n] = target[--n];
          }
          target[i] = temp;
          break;
        }
      }
    }
    return target;
  }
}
