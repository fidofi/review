package com.fidofi.review.socket.BIO;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** @Auther: fido @Date: 2018/7/4 11:16 @Description:BIO模式实现的服务端 */
@Slf4j
public class Server {
  private static final Integer PORT = 8082;

  public static synchronized void start() {
    try {
      ServerSocket serverSocket = new ServerSocket(PORT);
      log.info("服务端开始监听客户端请求");
      while (true) {
        Socket socket = serverSocket.accept(); // 阻塞监听
        // 若成功监听，则新启动一个线程处理
        //        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //        executorService.execute(new Thread(new ServerHandler(socket)));
        new Thread(new ServerHandler(socket)).start();
      }
    } catch (IOException e) {
      e.printStackTrace();
      log.info("服务端监听异常");
    }
  }
}
