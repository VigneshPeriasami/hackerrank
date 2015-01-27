package com.github.vignesh_iopex.linkedlist;

public class LinkedList<T> {
  private Node<T> head;
  private Node<T> lastNode;

  public LinkedList() {

  }

  public void append(T data) {
    if (head == null) {
      head = new Node<T>();
      head.data = data;
      lastNode = head;
    } else {
      lastNode.next = new Node<T>();
      lastNode.next.data = data;
      lastNode = lastNode.next;
    }
  }

  public void push(T data) {
    Node<T> newHead = new Node<T>();
    newHead.data = data;
    newHead.next = head;
    head = newHead;
  }

  public Node getNodeAt(int position) {
    Node ref = head;
    Node result;
    int index = 0;
    do {
      result = ref;
      if (result == null)
        throw new ArrayIndexOutOfBoundsException("position: " + position);
      ref = ref.next;
      index++;
    } while (index <= position);
    return result;
  }

  public class Node<E> {
    public Node<E> next;
    public E data;
  }
}
