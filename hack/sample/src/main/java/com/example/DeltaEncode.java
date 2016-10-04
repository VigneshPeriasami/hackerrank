package com.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DeltaEncode {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    List<Integer> loadUp = new LinkedList<>();
    while (reader.hasNextInt()) {
      loadUp.add(reader.nextInt());
    }

    for (int i = 0; i < loadUp.size(); i++) {
      int current = loadUp.get(i);
      int prev = 0;
      int currentResult;
      if (i > 0) {
        prev = loadUp.get(i - 1);
      }
      currentResult = current - prev;
      if (currentResult > 127 || currentResult < -127) {
        System.out.print("-128 " + currentResult + " ");
      } else {
        System.out.print(currentResult + " ");
      }
    }
  }
}
