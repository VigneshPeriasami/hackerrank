package com.github.vignesh_iopex.tests.stack;

import com.github.vignesh_iopex.stack.Stack;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class StackTest {

  @Test public void constructStack() {
    Stack<Integer> stack = new Stack<Integer>(2);
    stack.push(1);
    assertThat(stack.topPosition()).isEqualTo(0);
    stack.push(2);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.topPosition()).isEqualTo(0);
    stack.pop();
    assertThat(stack.topPosition()).isEqualTo(-1);
  }

  @Test public void exceptionOnPushBeyondCapacity() {
    Stack<Integer> stack = new Stack<Integer>(2);
    stack.push(1);
    stack.push(2);
    try {
      stack.push(3);
      fail("Exception not thrown at push beyond stack capacity");
    } catch (ArrayIndexOutOfBoundsException e) {
      assertThat(stack.topPosition()).isEqualTo(1);
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
      fail("Exception not thrown on pop at empty stack.");
    } catch (ArrayIndexOutOfBoundsException e) {
      assertThat(stack.topPosition()).isEqualTo(-1);
    }
  }

}
