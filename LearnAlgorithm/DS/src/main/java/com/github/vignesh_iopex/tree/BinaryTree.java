package com.github.vignesh_iopex.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <N> {
  private N[] nodeInfo;
  private Node<N> rootNode;
  public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    public int treeLevel;
    public T data;
  }

  public BinaryTree(N[] arrayRepresentation) {
    this.nodeInfo = arrayRepresentation;
  }

  public void buildTree() {
    rootNode = new Node<>();
    rootNode.treeLevel = 1;
    rootNode.data = nodeInfo[0];
    Queue<Node<N>> nodesToConstruct = new LinkedList<>();
    nodesToConstruct.add(rootNode);

    while(!nodesToConstruct.isEmpty()) {
      Node<N> parent = nodesToConstruct.remove();
      int leftNodePos = (2 * parent.treeLevel);
      int rightNodePos = (2 * parent.treeLevel) + 1;
      if (leftNodePos <= nodeInfo.length && nodeInfo[leftNodePos - 1] != null) {
        parent.left = new Node<>();
        parent.left.data = nodeInfo[leftNodePos - 1];
        parent.left.treeLevel = leftNodePos;
        nodesToConstruct.add(parent.left);
      }

      if (rightNodePos <= nodeInfo.length && nodeInfo[rightNodePos - 1] != null) {
        parent.right = new Node<>();
        parent.right.data = nodeInfo[rightNodePos - 1];
        parent.right.treeLevel = rightNodePos;
        nodesToConstruct.add(parent.right);
      }
    }
  }

  public Node<N> getRootNode() {
    return rootNode;
  }
}
