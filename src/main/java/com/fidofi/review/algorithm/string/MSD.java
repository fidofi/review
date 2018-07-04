package com.fidofi.review.algorithm.string;

import java.util.Arrays;

/** @Auther: fido @Date: 2018/6/25 23:07 @Description:高位优先的字符串排序 */
public class MSD {

  // 返回字符串指定索引位置的字符，如果索引位置值等于字符串长度值，则返回-1
  private static int charAt(String s, int d) {
    assert d >= 0 && d <= s.length();
    if (d == s.length()) return -1;
    return s.charAt(d);
  }

  private static void sort(String[] a, int lo, int hi, int d, String[] temp) {
    if (hi <= lo) {
      return;
    }
    int R = 256;

    // 计算出现频率
    int[] count = new int[R + 2]; // 加2是因为把超出字符串索引找不到的字符也当做一个字符，注意低位优先算法是+1
    for (int i = lo; i <= hi; i++) {
      int c = charAt(a[i], d);
      count[c + 2]++;
    }

    // 计算迁移到临时数组的起始索引
    for (int r = 0; r < R + 1; r++) count[r + 1] += count[r];

    // 对字符串进行分类
    for (int i = lo; i <= hi; i++) {
      int c = charAt(a[i], d);
      temp[count[c + 1]++] = a[i];
    }

    // 回写
    for (int i = lo; i <= hi; i++) a[i] = temp[i - lo];

    // 递归的以各个字符进行分类
    for (int r = 0; r < R; r++) sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, temp);
  }

  // 交换a[i] 与 a[j] 两个字符串
  private static void exch(String[] a, int i, int j) {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void sortByMSD(String[] a) {
    int N = a.length;
    String[] temp = new String[N];
    sort(a, 0, N - 1, 0, temp);
  }

  public static void main(String... args) {
    String[] a = new String[] {"aaaabbbb", "bbbbbbbb", "ccccdddd", "ccccaaaa"};
    sortByMSD(a);
    System.out.println(Arrays.toString(a));
  }
}
