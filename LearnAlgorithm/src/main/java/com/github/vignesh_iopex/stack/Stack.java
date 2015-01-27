package com.github.vignesh_iopex.stack;

public class Stack<T> {
  private int top;
  private int capacity;
  private T[] stack;

  @SuppressWarnings("unchecked")
  public Stack(int capacity) {
    this.capacity = capacity;
    this.stack = (T []) new Object[capacity];
    this.top = -1;
  }

  public void push(T data) {
    if (top == capacity -1)
      throw new ArrayIndexOutOfBoundsException("Stack size exceeded");
    stack[++top] = data;
  }

  public T pop() {
    if (top == -1)
      throw new ArrayIndexOutOfBoundsException("Stack is empty");
    return stack[top--];
  }

  public T peek() {
    return stack[top];
  }

  public int topPosition() {
    return top;
  }

  public int size() {
    return this.capacity;
  }
}
