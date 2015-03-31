package com.github.vignesh_iopex.tests.linkedlist;

import com.github.vignesh_iopex.linkedlist.LinkedList;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
public class LinkedListTest {

  @Test public void constructLinkedList() {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    linkedList.append(1);
    linkedList.append(2);
    assertThat(linkedList.getNodeAt(0).data).isEqualTo(1);
    linkedList.push(0);
    assertThat(linkedList.getNodeAt(0).data).isEqualTo(0);
    assertThat(linkedList.getNodeAt(1).data).isEqualTo(1);
    assertThat(linkedList.getNodeAt(2).data).isEqualTo(2);
  }

  @Test public void throwIndexOutOfBound() {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();
    linkedList.append(1);
    linkedList.append(2);
    try {
      linkedList.getNodeAt(2);
      fail("Array getNodeAt should be less than list capacity");
    } catch (ArrayIndexOutOfBoundsException e) {
      assertThat(linkedList.getNodeAt(1).data).isEqualTo(2);
    }
  }
}
