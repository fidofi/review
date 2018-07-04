package com.fidofi.review.jvm.loading;

import java.io.*;

/** @Auther: fido @Date: 2018/7/2 23:05 @Description:自定义类加载器 */
public class MyClassLoader extends ClassLoader {
  private String root;

  protected Class<?> findClass(String name) throws ClassNotFoundException {
    byte[] classData = loadClassData(name);
    if (classData == null) {
      throw new ClassNotFoundException();
    } else {
      return defineClass(name, classData, 0, classData.length);
    }
  }

  private byte[] loadClassData(String className) {
    String fileName =
        root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    try {
      InputStream ins = new FileInputStream(fileName);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      int bufferSize = 1024;
      byte[] buffer = new byte[bufferSize];
      int length = 0;
      while ((length = ins.read(buffer)) != -1) {
        baos.write(buffer, 0, length);
      }
      return baos.toByteArray();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getRoot() {
    return root;
  }

  public void setRoot(String root) {
    this.root = root;
  }

  public static void main(String[] args) {

    MyClassLoader classLoader = new MyClassLoader();
    classLoader.setRoot("E:\\temp");

    Class<?> testClass = null;
    try {
      testClass = classLoader.loadClass("com.neo.classloader.Test2");
      Object object = testClass.newInstance();
      System.out.println(object.getClass().getClassLoader());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}