package com.fidofi.review.jvm.loading;

/** @Auther: fido @Date: 2018/7/2 22:57 @Description: */
public class ClassLoaderTest {
  public static void main(String[] args) {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    System.out.println(loader);
    System.out.println(loader.getParent());
    System.out.println(loader.getParent().getParent());
  }
    }
