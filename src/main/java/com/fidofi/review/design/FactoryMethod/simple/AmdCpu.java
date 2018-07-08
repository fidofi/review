package com.fidofi.review.design.FactoryMethod.simple;

/** @Auther: fido @Date: 2018/7/6 23:28 @Description: */
public class AmdCpu implements Cpu {
  /** CPU的针脚数 */
  private int pins = 0;

  public AmdCpu(int pins) {
    this.pins = pins;
  }

  @Override
  public void calculate() {
    // TODO Auto-generated method stub
    System.out.println("AMD CPU的针脚数：" + pins);
  }
}
