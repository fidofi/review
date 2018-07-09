package com.fidofi.review.algorithm.sort;

/** @Auther: fido @Date: 2018/7/8 12:18 @Description: 快速排序 */
public class QuickSort implements Sort {

  @Override
  public int[] sort(int[] target) {
    int start = 0;
    int end = target.length;
    sort(target, start, end);
    return target;
  }

  public void sort(int[] target, int start, int end) {
    if (start >= end - 1) {
      return;
    }
    int i = partition(target, start, end);
    sort(target, start, i);
    sort(target, i + 1, end);
  }
  /**
   * 划分算法 将给定的基准归到数组的最终位置
   *
   * @param target
   * @param start
   * @param end
   * @return
   */
  public int partition(int[] target, int start, int end) {
    int i = start;
    int source = target[start];
    while (true) {
      while (start < end - 1 && target[++start] < source) {}
      while (i < end && target[--end] > source) {}
      if (start >= end) {
        break;
      }
      ArrayUtils.swap(target, start, end);
    }
    ArrayUtils.swap(target, i, end);
    return end;
  }

  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    int[] target = ArrayUtils.getRandomArray(6);
    for (int c : target) {
      System.out.print(c + "、");
    }
    System.out.println(quickSort.partition(target, 0, target.length));
    for (int c : target) {
      System.out.print(c + "、");
    }
  }
}
