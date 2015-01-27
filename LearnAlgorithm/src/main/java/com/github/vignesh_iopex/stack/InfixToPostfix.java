package com.github.vignesh_iopex.stack;

public class InfixToPostfix {
  private char[] exp;

  public InfixToPostfix(char[] exp) {
    this.exp = exp;
  }

  private boolean isOperand(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private int precedence(char c) {
    switch (c) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
      default: return -1;
    }
  }

  public char[] getAsPostFix() {
    Stack<Character> stack = new Stack<Character>(exp.length);
    int k = -1;
    for (int i = 0; i < exp.length; i++) {
      if (isOperand(exp[i])) {
        exp[++k] = exp[i];
      } else if (exp[i] == '(') {
        stack.push(exp[i]);
      } else if (exp[i] == ')') {
        while (!(stack.topPosition() == -1) && stack.peek() != '(') {
          exp[++k] = stack.pop();
        }
        if (!(stack.topPosition() == -1) && stack.peek() != '(') {
          throw new IllegalArgumentException("Invalid expression");
        } else {
          stack.pop();
        }
      } else {
        // if an operator...
        while (stack.topPosition() != -1 && precedence(exp[i]) <= precedence(stack.peek())) {
          exp[++k] = stack.pop();
        }
        stack.push(exp[i]);
      }
    }
    // pop all the operators
    while (stack.topPosition() != -1) {
      exp[++k] = stack.pop();
    }
    return exp;
  }
}
