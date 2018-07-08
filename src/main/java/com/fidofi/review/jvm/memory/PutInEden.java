package com.fidofi.review.jvm.memory;

/** @Auther: fido @Date: 2018/7/7 13:35 @Description: */
public class PutInEden {
  public static void main(String[] args) {
    byte[] b1, b2, b3, b4;
    /** 分配 1MB 堆空间，考察堆空间的使用情况 */
    b1 = new byte[1024 * 1024];
    b2 = new byte[1024 * 1024];
    b3 = new byte[1024 * 1024];
    b4 = new byte[1024 * 1024];
  }
}
