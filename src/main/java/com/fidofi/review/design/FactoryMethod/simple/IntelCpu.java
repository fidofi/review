package com.fidofi.review.design.FactoryMethod.simple;

/** @Auther: fido @Date: 2018/7/6 23:26 @Description: */
public class IntelCpu implements Cpu {
  /** cpu的针脚数 */
  private Integer pins = 0;

  public IntelCpu(Integer pins) {
    this.pins = pins;
  }

  @Override
  public void calculate() {
    System.out.println("Intel Cpu 的针脚数为：" + pins);
  }
}
