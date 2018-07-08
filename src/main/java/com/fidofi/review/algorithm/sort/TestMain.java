package com.fidofi.review.algorithm.sort;

import org.junit.Before;
import org.junit.Test;

/** @Auther: fido @Date: 2018/7/8 10:46 @Description:测试排序方法 */
public class TestMain {
  private int[] target = ArrayUtils.getRandomArray(10);

  @Before
  public void testBefore() {
    System.out.println("排序前的数组");
    ArrayUtils.printArray(target);
  }

  @Test
  public void testSelectionSort() {
    SelectionSort selectionSort = new SelectionSort();
    System.out.println("排序后的数组");
    ArrayUtils.printArray(selectionSort.sort(target));
  }

  @Test
  public void testBubbleSort() {
    BubbleSort bubbleSort = new BubbleSort();
    System.out.println("排序后的数组");
    ArrayUtils.printArray(bubbleSort.sort(target));
  }

  @Test
  public void testInsertionSort() {
    InsertionSort insertionSort = new InsertionSort();
    System.out.println("排序后的数组");
    ArrayUtils.printArray(insertionSort.sort(target));
  }
}
