package com.example;

import java.util.LinkedList;
import java.util.List;

public class ExplainTree {
  public static void main(String[] args) {
    int[] tree = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    StringBuilder output = new StringBuilder();
    explainInorder(output, tree);
    System.out.println(output.toString());
  }

  public static void explainInorder(StringBuilder out, int[] tree) {
    explainInorder(out, tree, 0);
  }

  public static void explainInorder(StringBuilder out, int[] tree, int position) {
    if (position >= tree.length) {
      return;
    }
    explainInorder(out, tree, left(position));
    out.append(tree[position]);
    explainInorder(out, tree, right(position));
  }

  public static void explainPostOrder(StringBuilder out, int[] tree) {
    explainPostOrder(out, tree, 0);
  }

  public static void explainPostOrder(StringBuilder out, int[] tree, int position) {
    if (position >= tree.length) {
      return;
    }
    explainPostOrder(out, tree, left(position));
    explainPostOrder(out, tree, right(position));
    out.append(tree[position]);
  }

  public static void explainPreOrder(StringBuilder out, int[] tree) {
    explainPreOrder(out, tree, 0);
  }

  public static void explainPreOrder(StringBuilder out, int[] tree, int position) {
    if (position >= tree.length) {
      return;
    }

    out.append(tree[position]);
    explainPreOrder(out, tree, left(position));
    explainPreOrder(out, tree, right(position));
  }

  public static void explainByLevel(StringBuilder output, int[] tree) {
    printLevel(output, tree, 0);
  }

  public static void printLevel(StringBuilder out, int[] tree, Integer... positions) {
    List<Integer> nextPosibleLevels = new LinkedList<>();

    for (int pos : positions) {
      if (pos == 0) {
        out.append(tree[pos]);
        out.append("\n");
      }
      if (left(pos) < tree.length) {
        out.append(tree[left(pos)]);
        nextPosibleLevels.add(left(pos));
      }
      if (right(pos) < tree.length) {
        out.append(tree[right(pos)]);
        nextPosibleLevels.add(right(pos));
      }
    }
    if (nextPosibleLevels.isEmpty()) {
      return;
    }
    out.append("\n");
    printLevel(out, tree, nextPosibleLevels.toArray(new Integer[nextPosibleLevels.size()]));
  }

  public static int left(int root) {
    return root * 2 + 1;
  }

  public static int right(int root) {
    return root * 2 + 2;
  }
}
