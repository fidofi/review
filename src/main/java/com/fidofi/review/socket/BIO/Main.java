package com.fidofi.review.socket.BIO;

import java.util.Random;

/** @Auther: fido @Date: 2018/7/4 13:50 @Description: 模拟客户端和服务端 */
public class Main {
  public static void main(String[] args) {
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                Server.start();
              }
            })
        .start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    char operators[] = {'+', '-', '*', '/'};
    Random random = new Random(System.currentTimeMillis());
    new Thread(
            new Runnable() {
              @SuppressWarnings("static-access")
              @Override
              public void run() {
                while (true) {
                  // 随机产生算术表达式
                  String expression =
                      random.nextInt(10)
                          + ""
                          + operators[random.nextInt(4)]
                          + (random.nextInt(10) + 1);
                  Client.send(expression);
                  try {
                    Thread.currentThread().sleep(random.nextInt(1000));
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                }
              }
            })
        .start();
  }
}
