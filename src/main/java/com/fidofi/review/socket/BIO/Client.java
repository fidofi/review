package com.fidofi.review.socket.BIO;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/** @Auther: fido @Date: 2018/7/4 13:43 @Description: 模拟客户端 */
@Slf4j
public class Client {
  private static final Integer PORT = 8082;
  private static final String IP = "localhost";

  public static void send(String experssion) {
    System.out.println("客户端发送的算数表达式为" + experssion);
    Socket socket = null;
    BufferedReader bufferedReader = null;
    PrintWriter printWriter = null;
    try {
      socket = new Socket(IP, PORT); // 通过套接字与服务端进行连接
      bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      printWriter = new PrintWriter(socket.getOutputStream());
      printWriter.println(experssion);
      printWriter.flush();
      System.out.println("客户端接收的运算结果为" + bufferedReader.readLine());
    } catch (Exception e) {
      log.info("客户端发生异常");
    }
  }
}
