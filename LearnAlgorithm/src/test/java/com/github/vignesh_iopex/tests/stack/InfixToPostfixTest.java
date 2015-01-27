package com.github.vignesh_iopex.tests.stack;

import com.github.vignesh_iopex.stack.InfixToPostfix;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InfixToPostfixTest {

  @Test public void convertInfixToPostFix() {
    InfixToPostfix infixToPostfix = new InfixToPostfix("a+b*c+d".toCharArray());
    assertEquals("abc*+d+", String.valueOf(infixToPostfix.getAsPostFix()));
  }
}
