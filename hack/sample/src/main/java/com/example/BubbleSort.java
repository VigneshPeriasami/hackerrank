package com.example;

import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] arrToSort = new int[] { 2, 1, 4, 5, 3 };
    System.out.println(Arrays.toString(arrToSort));
    while(bubblesort(arrToSort, 0 , false)) {
      System.out.println(Arrays.toString(arrToSort));
    }
  }

  private static boolean bubblesort(int[] arr, int start, boolean hasSwapped) {
    if (start >= arr.length) {
      return hasSwapped;
    }
    if (start == 0) {
      return bubblesort(arr, ++start, hasSwapped);
    }

    if (arr[start - 1] > arr[start]) {
      swap(arr, start - 1, start);
      hasSwapped = true;
    }
    return bubblesort(arr, ++start, hasSwapped);
  }

  private static void swap(int[] arr, int a, int b) {
    int ref = arr[a];
    arr[a] = arr[b];
    arr[b] = ref;
  }
}
