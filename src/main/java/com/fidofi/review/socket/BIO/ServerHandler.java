package com.fidofi.review.socket.BIO;

import com.fidofi.review.socket.Calculate;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/** @Auther: fido @Date: 2018/7/4 11:26 @Description: 用于处理客户端请求 */
@Slf4j
public class ServerHandler implements Runnable {
  private Socket socket;

  public Socket getSocket() {
    return socket;
  }

  public ServerHandler(Socket socket) {
    this.socket = socket;
  }

  public void setSocket(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    BufferedReader reader = null;
    PrintWriter printWriter = null;
    try {
      reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      printWriter = new PrintWriter(socket.getOutputStream());
      String expression = null;
      while ((expression = reader.readLine()) != null) {
        System.out.println("服务端接收到客户端的消息为" + expression);
        double result = Calculate.calculate(expression);
        printWriter.println(result);
        printWriter.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          log.info("关闭输入流异常");
          e.printStackTrace();
        }
        reader = null;
      }
      if (printWriter != null) {
        printWriter.close();
      }
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          log.info("关闭socket异常");
          e.printStackTrace();
        }
        socket = null;
      }
    }
  }
}
