package com.example;

import java.util.Arrays;
import java.util.Scanner;

public class Candies {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();
    int[] ranks = new int[count];
    for (int i = 0; i < count; i++) {
      ranks[i] = scanner.nextInt();
    }
    int[] candies = new int[count];
    requiredCandiesForNPosition(count - 1, ranks, candies);
    System.out.println(Arrays.toString(candies));
    int candiesCount = 0;
    for (int i = 0; i < candies.length; i++) {
      candiesCount += candies[i];
    }
    System.out.println(candiesCount);
  }

  private static int requiredCandiesForNPosition(int n, int[] ranks, int[] candies) {
    if (n == 0) {
      candies[0] = 1;
      return 1;
    }
    int prevGuy = requiredCandiesForNPosition(n - 1, ranks, candies);
    int currentGuy = 1;
    if (ranks[n] > ranks[n - 1]) {
      currentGuy = currentGuy + prevGuy;
    } else if (ranks[n] < ranks[n - 1] && candies[n - 1] <= currentGuy) {
      candies[n - 1] = currentGuy + candies[n - 1];
    }
    candies[n] = currentGuy;
    return candies[n];
  }
}
