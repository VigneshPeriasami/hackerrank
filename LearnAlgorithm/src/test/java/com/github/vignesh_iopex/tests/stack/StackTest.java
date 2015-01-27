package com.github.vignesh_iopex.tests.stack;

import com.github.vignesh_iopex.stack.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StackTest {

  @Test public void constructStack() {
    Stack<Integer> stack = new Stack<Integer>(2);
    stack.push(1);
    assertEquals(0, stack.topPosition());
    stack.push(2);
    assertEquals((Integer) 2, stack.pop());
    assertEquals(0, stack.topPosition());
    stack.pop();
    assertEquals(-1, stack.topPosition());
  }

  @Test public void exceptionOnPushBeyondCapacity() {
    Stack<Integer> stack = new Stack<Integer>(2);
    stack.push(1);
    stack.push(2);
    try {
      stack.push(3);
      fail();
    } catch (ArrayIndexOutOfBoundsException e) {
      assertEquals(stack.topPosition(), 1);
    }
  }

  @Test public void exceptionOnPopOnEmpty() {
    Stack<Integer> stack = new Stack<Integer>(2);
    stack.push(1);
    stack.push(2);
    try {
      stack.pop();
      stack.pop();
      stack.pop();
      fail();
    } catch (ArrayIndexOutOfBoundsException e) {
      assertEquals(-1, stack.topPosition());
    }
  }

}
