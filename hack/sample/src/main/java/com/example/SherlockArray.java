package com.example;

import java.util.Scanner;

public class SherlockArray {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();
    for (int t = 0; t < testCases; t++) {
      int len = scanner.nextInt();
      int[] arr = new int[len];
      for (int i = 0; i < len; i++) {
        arr[i] = scanner.nextInt();
      }
      System.out.println(hasSpecialElement(arr) ? "YES" : "NO");
    }
  }

  private static int findSum(int[] arr) {
    return findSum(arr, 0, 0);
  }

  private static int findSum(int[] arr, int sum, int index) {
    if (index >= arr.length) {
      return sum;
    }
    return findSum(arr, sum + arr[index], ++index);
  }

  private static boolean hasSpecialElement(int[] arr) {
    return hasSpecialElement(arr, 0, findSum(arr), 0);
  }

  private static boolean hasSpecialElement(int[] arr, int leftSum, int rightSum, int index) {
    if (index == 0 && index <= arr.length - 2) {
      return hasSpecialElement(arr, arr[index], rightSum - (arr[index] + arr[index + 1]), ++index);
    } else if (index > arr.length - 2) {
      return false;
    }

    if (leftSum == rightSum) {
      return true;
    }
    return hasSpecialElement(arr, leftSum + arr[index], rightSum - arr[index + 1], ++index);
  }
}
