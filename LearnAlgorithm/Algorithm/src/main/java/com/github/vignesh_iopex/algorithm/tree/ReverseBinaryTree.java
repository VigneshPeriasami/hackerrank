package com.github.vignesh_iopex.algorithm.tree;

import java.io.InputStreamReader;
import java.util.*;

public class ReverseBinaryTree {
  public static HashMap<Integer, LinkedList<Integer>> hashEm(int[] arr) {
    HashMap<Integer, LinkedList<Integer>> hashed = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int value = arr[i];
      if (!hashed.containsKey(arr[i])) {
        hashed.put(arr[i], new LinkedList<Integer>());
      }
      hashed.get(arr[i]).add(i);
    }
    return hashed;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    scanner.nextLine();
    String line = scanner.nextLine();
    String[] numberStrs = line.split(" ");
    int[] arr = new int[numberStrs.length];
    for(int i = 0;i < numberStrs.length;i++)
    {
      arr[i] = Integer.parseInt(numberStrs[i]);
    }

    HashMap<Integer, LinkedList<Integer>> hashed = hashEm(arr);

    final Integer root = hashed.get(-1).get(0);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(root);
    HashMap<Integer, Integer> treeLevel = new HashMap<>();
    HashMap<Integer, LinkedList<Integer>> levelWiseHolder = new HashMap<>();
    treeLevel.put(root, 0);
    levelWiseHolder.put(0, new LinkedList<Integer>() {{ add(root); }});
    // load them with the root data.
    while (!queue.isEmpty()) {
      Integer rootElement = queue.remove();
      int rootLevel = treeLevel.get(rootElement);

      LinkedList<Integer> childNode = hashed.get(rootElement);
      if (childNode == null) {
        continue;
      }
      // init level wise holder for child nodes....
      LinkedList<Integer> levelWise = levelWiseHolder.get(rootLevel + 1);
      if (levelWise == null) {
        levelWise = new LinkedList<>();
        levelWiseHolder.put(rootLevel + 1, levelWise);
      }
      for(Integer i : childNode) {
        queue.add(i);
        treeLevel.put(i, rootLevel + 1);
        levelWise.add(i);
      }
    }

    Stack<String> output = new Stack<>();
    for (Map.Entry<Integer, LinkedList<Integer>> entry : levelWiseHolder.entrySet()) {
      String prnt = "";
      for (Integer i : entry.getValue()) {
        prnt += i + " ";
      }
      output.add(prnt.trim());
    }
    while(!output.empty()) {
      System.out.println(output.pop());
    }
  }
}
