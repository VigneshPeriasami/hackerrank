package com.github.vignesh_iopex.tests.linkedlist;

import com.github.vignesh_iopex.linkedlist.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LinkedListTest {

  @Test public void constructLinkedList() {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    linkedList.append(1);
    linkedList.append(2);
    assertEquals(1, linkedList.getNodeAt(0).data);
    linkedList.push(0);
    assertEquals(0, linkedList.getNodeAt(0).data);
    assertEquals(1, linkedList.getNodeAt(1).data);
    assertEquals(2, linkedList.getNodeAt(2).data);
  }

  @Test public void throwIndexOutOfBound() {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    linkedList.append(1);
    linkedList.append(2);
    try {
      linkedList.getNodeAt(2);
      fail();
    } catch (ArrayIndexOutOfBoundsException e) {
      assertEquals(2, linkedList.getNodeAt(1).data);
    }
  }
}
