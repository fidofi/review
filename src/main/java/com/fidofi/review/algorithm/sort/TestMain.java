package com.fidofi.review.algorithm.sort;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;

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

  @Test
  public void testQuickSort() {
    QuickSort quickSort = new QuickSort();
    System.out.println("快速排序后的数组");
    ArrayUtils.printArray(quickSort.sort(target));
  }

  @Test
  public void testHeapSort() {
    HeapSort heapSort = new HeapSort();
    System.out.println("堆排序后的数组");
    ArrayUtils.printArray(heapSort.sort(target));
  }
}
