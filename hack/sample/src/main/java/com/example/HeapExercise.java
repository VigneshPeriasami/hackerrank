package com.example;

import java.util.ArrayList;
import java.util.List;

public class HeapExercise {

  interface HeapCondition {
    boolean swapEligible(int rootValue, int childValue);

    HeapCondition MAX_HEAP = (rootValue, childValue) -> rootValue < childValue;
    HeapCondition MIN_HEAP = (rootValue, childValue) -> rootValue > childValue;
  }

  public static void main(String[] args) {
    List<Integer> heap = new ArrayList<>();
    int[] entries = new int[] {4, 10, 3, 5, 1};

    for (int entry : entries) {
      heap.add(entry);
    }

    heapify(heap, heap.size() - 1, false, HeapCondition.MIN_HEAP);
    for (int ent : heap) {
      System.out.println(ent);
    }
  }

  public static void heapify(List<Integer> heap,
                             int level, boolean hasSwapped, HeapCondition heapCondition) {
    int rootPosition = root(level);
    if (rootPosition < 0 && !hasSwapped) {
      return;
    } else if (rootPosition < 0 && hasSwapped) {
      heapify(heap, heap.size() - 1, false, heapCondition);
      return;
    }
    if (heapCondition.swapEligible(heap.get(rootPosition), heap.get(left(rootPosition)))) {
      swap(heap, rootPosition, left(rootPosition));
      hasSwapped = true;
    }
    if (heapCondition.swapEligible(heap.get(rootPosition), heap.get(right(rootPosition)))) {
      swap(heap, rootPosition, right(rootPosition));
      hasSwapped = true;
    }
    heapify(heap, rootPosition, hasSwapped, heapCondition);
  }

  public static void swap(List<Integer> heap, int a, int b) {
    int valueA = heap.get(a);
    int valueB = heap.get(b);
    heap.set(a, valueB);
    heap.set(b, valueA);
  }

  public static int root(int position) {
    if (position % 2 == 0) {
      return (position - 2) / 2;
    }
    return (position - 1) / 2;
  }

  public static int right(int position) {
    return 2 * position + 2;
  }

  public static int left(int position) {
    return 2 * position + 1;
  }
}
