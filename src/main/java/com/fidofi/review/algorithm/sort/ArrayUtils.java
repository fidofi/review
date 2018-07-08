package com.fidofi.review.algorithm.sort;

import java.util.Random;

/** @Auther: fido @Date: 2018/7/8 10:55 @Description:一些用于测试的工具类 */
public class ArrayUtils {
  /**
   * 打印数组
   *
   * @param target
   */
  public static void printArray(int[] target) {
    for (int i = 0; i < target.length; i++) {
      if (i != target.length - 1) {
        System.out.print(target[i] + "、");
      } else {
        System.out.print(target[i]);
        System.out.println("");
      }
    }
  }

  /**
   * 产生给定长度的随机数组
   *
   * @param nums
   * @return
   */
  public static int[] getRandomArray(int nums) {
    int[] result = new int[nums];
    Random random = new Random();
    for (int i = 0; i < nums; i++) {
      result[i] = random.nextInt(1000);
    }
    return result;
  }

  /**
   * 交换数组制定下标的两个值
   *
   * @param target
   * @param start
   * @param end
   * @return
   */
  public static int[] swap(int[] target, int start, int end) {
    int temp = target[start];
    target[start] = target[end];
    target[end] = temp;
    return target;
  }
}
