package com.fidofi.review.socket;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/** @Auther: fido @Date: 2018/7/4 19:39 @Description: some code to compare bio to nio */
public class Test {
  public static void method1() {
    RandomAccessFile aFile = null;
    try {
      aFile = new RandomAccessFile("D://test.txt","rw");
      FileChannel fileChannel = aFile.getChannel();
      ByteBuffer buf = ByteBuffer.allocate(1024);
      int bytesRead = fileChannel.read(buf);
      System.out.println(bytesRead);
      while (bytesRead != -1) {
//        buf.flip();
        while (buf.hasRemaining()) {
          System.out.print((char) buf.get());
        }

        buf.compact();
        bytesRead = fileChannel.read(buf);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (aFile != null) {
          aFile.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void method2() {}

  public static void main(String[] args) {
    method1();
  }
}
