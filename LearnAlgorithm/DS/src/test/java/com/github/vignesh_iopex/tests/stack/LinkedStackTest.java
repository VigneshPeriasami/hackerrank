package com.github.vignesh_iopex.tests.stack;

import com.github.vignesh_iopex.stack.LinkedStack;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class LinkedStackTest {

  @Test public void stackBasicOperations() {
    LinkedStack<Integer> stack = new LinkedStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertThat(stack.size()).isEqualTo(3);
    assertThat(stack.peek()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.pop()).isEqualTo(1);
    assertThat(stack.size()).isEqualTo(0);
  }

  @Test public void exceptionPopOnEmptyStack() {
    LinkedStack<Integer> stack = new LinkedStack<>();
    stack.push(1);
    assertThat(stack.pop()).isEqualTo(1);
    try {
      stack.pop();
      fail("Exception not thrown on pop on empty stack.");
    } catch (EmptyStackException e) {
      assertThat(stack.size()).isEqualTo(0);
    }
  }
}
