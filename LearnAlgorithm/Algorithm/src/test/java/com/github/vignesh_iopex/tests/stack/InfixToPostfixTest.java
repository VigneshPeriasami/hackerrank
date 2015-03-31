package com.github.vignesh_iopex.tests.stack;

import com.github.vignesh_iopex.algorithm.stack.InfixToPostfix;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InfixToPostfixTest {

  @Test public void convertInfixToPostFix() {
    InfixToPostfix infixToPostfix = new InfixToPostfix("a+b*c+d".toCharArray());
    assertThat(infixToPostfix.getAsPostFix()).containsSequence('a', 'b', 'c', '*', '+', 'd', '+');
  }
}
