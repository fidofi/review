package com.fidofi.review.socket.NIO;

import java.util.Scanner;

/** @Auther: fido @Date: 2018/7/4 14:33 @Description: */
public class Test {
  // 测试主方法
  public static void main(String[] args) throws Exception {
    // 运行服务器
    Server.start();
    // 避免客户端先于服务器启动前执行代码
    Thread.sleep(100);
    // 运行客户端
    Client.start();
    while (Client.sendMsg(new Scanner(System.in).nextLine())) ;
  }
}
