package com.fidofi.review.algorithm.sort;

/** @Auther: fido @Date: 2018/7/8 12:18 @Description:归并排序 */
public class HeapSort implements Sort {
  @Override
  public int[] sort(int[] target) {
    int end = target.length - 1;
    for (int i = end / 2; i >= 0; i--) {
      sink(target, i, end);
    }

    while (end >= 0) {
      ArrayUtils.swap(target, 0, end--);
      sink(target, 0, end);
    }
    return target;
  }

  /**
   * 对应堆排序的下沉操作
   *
   * @param target
   * @param start
   * @param end
   */
  private void sink(int[] target, int start, int end) {

    while (2 * start <= end) {
      /** j表明需要与当前节点交换的孩子节点 */
      int j = 2 * start;
      /** 有左孩子,右孩子，找到最大的那个 */
      if (j < end && less(target, j, j + 1)) {
        j++;
      }
      /** 说明此点下面的元素都符合堆的规则，因为排序的时候是从底部开始下沉的 */
      if (!less(target, start, j)) {
        break;
      }
      ArrayUtils.swap(target, start, j);
      /** 将当前节点置为其孩子节点 */
      start = j;
    }
  }

  /**
   * 比较第一个下标的数是否小于第二个下标
   *
   * @param target
   * @param start
   * @param end
   * @return
   */
  private boolean less(int[] target, int start, int end) {
    return target[start] < target[end];
  }
}
