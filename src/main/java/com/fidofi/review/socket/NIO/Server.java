package com.fidofi.review.socket.NIO;

/** @Auther: fido @Date: 2018/7/4 14:26 @Description: NIO的server端 */
public class Server {
  private static int DEFAULT_PORT = 12345;
  private static ServerHandler serverHandle;
  public static void start() {
    start(DEFAULT_PORT);
  }
  public static synchronized void start(int port) {
    if (serverHandle != null) serverHandle.stop();
    serverHandle = new ServerHandler(port);
    new Thread(serverHandle, "Server").start();
  }

  public static void main(String[] args) {
    start();
  }
}
