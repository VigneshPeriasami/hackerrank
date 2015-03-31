package com.github.vignesh_iopex.stack;

import java.util.EmptyStackException;

public class LinkedStack<D> {
  private class Node<T> {
    public Node<T> prev;
    public T data;
  }

  private Node<D> head;
  private long size = 0;

  public LinkedStack() {

  }

  public void push(D data) {
    Node<D> newNode = new Node<>();
    newNode.data = data;
    if (head == null) {
      head = newNode;
    } else {
      newNode.prev = head;
      head = newNode;
    }
    size++;
  }

  public D pop() {
    Node<D> popNode;
    if (head == null) {
      throw new EmptyStackException();
    }
    popNode = head;
    head = head.prev;
    size--;
    return popNode.data;
  }

  public long size() {
    return size;
  }

  public D peek() {
    return head.data;
  }
}
