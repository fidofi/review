package com.fidofi.review.design.DynamicProxy.cglib;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** @Auther: fido @Date: 2018/7/5 22:31 @Description: 实现方法拦截 */
public class HelloMethodInterceptor implements MethodInterceptor {
  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("before method," + method.getName());
    Object object = methodProxy.invokeSuper(o, objects);
    System.out.println("after method," + method.getName());
    return object;
  }
}
