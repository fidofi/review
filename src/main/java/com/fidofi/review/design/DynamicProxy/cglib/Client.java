package com.fidofi.review.design.DynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Auther: fido
 * @Date: 2018/7/5 22:33
 * @Description: 测试类
 */
public class Client {
  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(HelloServiceImpl.class);
    enhancer.setCallback(new HelloMethodInterceptor());
    HelloServiceImpl helloService = (HelloServiceImpl) enhancer.create();
    helloService.sayHello();
  }
}
