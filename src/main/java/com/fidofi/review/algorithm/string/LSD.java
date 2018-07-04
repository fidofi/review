package com.fidofi.review.algorithm.string;

import java.util.Arrays;

/** @Auther: fido @Date: 2018/6/25 21:53 @Description: 低位优先的字符串排序 */
public class LSD {
  public static void sort(String[] a, int W) {
    int length = a.length;
    String[] temp = new String[length]; // 临时存放排序好的字符数组
    for (int d = W - 1; d >= 0; d--) {
      int[] count = new int[257]; // ascii表中可见字符为256个
      for (int i = 0; i < length; i++) {
        count[a[i].charAt(d) + 1]++;
      }
      for (int i = 0; i < count.length - 1; i++) {
        count[i + 1] += count[i];
      }
      // 以上可得到某个组内共有几个元素
      // 对字符串元素进行分类
      for (int i = 0; i < length; i++) temp[count[a[i].charAt(d)]++] = a[i];

      // 回写
      for (int i = 0; i < length; i++) a[i] = temp[i];
    }
  }

  public static void main(String[] args) {
    String[] a = {"a1", "a3", "h8", "c6"};
    LSD.sort(a, 2);
    System.out.println(Arrays.toString(a));
  }
}
