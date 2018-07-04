package com.fidofi.review.socket;

import java.util.Stack;

/** @Auther: fido @Date: 2018/7/4 12:19 @Description: 计算表达式的结果 */
public class Calculate {
  /**
   * 根据表达式计算结果 先将中缀表达式转换成后缀表达式 再根据后缀表达式计算结果
   *
   * @param expression
   * @return
   */
  public static double calculate(String expression) {
    Stack<Character> stack = new Stack<>(); // 利用栈来实现中缀表达式转后缀表达式
    StringBuffer buffer = new StringBuffer(); // 用于存储后缀表达式
    char[] target = expression.toCharArray();
    for (char c : target) {
      if (c >= '0' && c <= '9') {
        buffer.append(c);
      }
      // 属于操作符
      else {
        if (stack.isEmpty()) {
          stack.push(c);
          continue;
        } else {
          switch (c) {
            case '(':
              stack.push(c);
              break;
            case '+':
              if (stack.peek() != '(') {
                while (!stack.isEmpty()) {
                  buffer.append(stack.pop());
                }
              }
              stack.push(c);
              break;
            case '-':
              if (stack.peek() != '(') {
                while (!stack.isEmpty()) {
                  buffer.append(stack.pop());
                }
              }
              stack.push(c);
              break;
            case '*':
              if (stack.peek() != '*' || stack.peek() != '/') {
                stack.push(c);
              } else {
                while (stack.peek() != '*' || stack.peek() != '/') {
                  buffer.append(stack.pop());
                }
              }
              break;
            case '/':
              if (stack.peek() != '*' || stack.peek() != '/') {
                stack.push(c);
              } else {
                while (stack.peek() != '*' || stack.peek() != '/') {
                  buffer.append(stack.pop());
                }
              }
              break;
            case ')':
              while (stack.peek() != '(') {
                buffer.append(stack.pop());
              }
              stack.pop();
              break;
          }
        }
      }
    }
    while (!stack.isEmpty()) {
      buffer.append(stack.pop());
    }
    char[] need2Calculate = buffer.toString().toCharArray();
    Stack<Double> stack1 = new Stack<>();
    for (char c : need2Calculate) {
      if (c >= '0' && c <= '9') {
        stack1.push(Double.valueOf(c - '0'));
      } else {
        double result = 0;
        double a = stack1.pop();
        double b = stack1.pop();
        switch (c) {
          case '+':
            result = b + a;
            break;
          case '-':
            result = b - a;
            break;
          case '*':
            result = b * a;
            break;
          case '/':
            result = b / a;
            break;
        }
        stack1.push(result);
      }
    }
    return stack1.pop();
  }

  public static void main(String[] args) {
    System.out.println("运算结果为" + Calculate.calculate("2*4+(5-1)"));
  }
}
