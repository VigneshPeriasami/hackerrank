package com.github.vignesh_iopex.tests.binarytree;

import com.github.vignesh_iopex.tree.BinaryTree;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeTest {

  @Test public void constructTreeFromArray() {
    Integer[] data = new Integer[] {1, 2, 3, 4};
    BinaryTree<Integer> binaryTree = new BinaryTree<>(data);
    binaryTree.buildTree();
    BinaryTree<Integer>.Node<Integer> rootNode = binaryTree.getRootNode();
    assertThat(rootNode.data).isEqualTo(1);
    assertThat(rootNode.left.data).isEqualTo(2);
    assertThat(rootNode.right.data).isEqualTo(3);
    assertThat(rootNode.left.treeLevel).isEqualTo(2);
    assertThat(rootNode.right.treeLevel).isEqualTo(3);
    assertThat(rootNode.left.left.data).isEqualTo(4);
    assertThat(rootNode.left.left.treeLevel).isEqualTo(4);
    assertThat(rootNode.left.right).isNull();
    assertThat(rootNode.right.left).isNull();
  }
}
