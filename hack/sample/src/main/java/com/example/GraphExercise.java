package com.example;

public class GraphExercise {

  public static class Vertex {
    public int value;
    public Vertex next;
    public AdjVertex adjVertex;

    public Vertex(int value) {
      this.value = value;
    }

    public void append(int newAdj) {
      if (adjVertex == null) {
        adjVertex = new AdjVertex(newAdj);
        return;
      }
      adjVertex.append(new AdjVertex(newAdj));
    }
  }

  public static class AdjVertex {
    public int value;
    public AdjVertex next;
    public AdjVertex(int value) {
      this.value = value;
    }

    public void append(AdjVertex newNext) {
      this.next = newNext;
    }
  }

  public static class Graph {
    public Vertex head;

    public void addEdge(int src, int dest) {
      if (head == null) {
        head = new Vertex(src);
      }
    }

    public void addEdge(Vertex current, int src, int dest) {
      if (current.value != src && current.next != null) {
        addEdge(current.next, src, dest);
        return;
      } else if (current.next == null) {
        current.next = new Vertex(dest);
        return;
      } else if (current.value == src) {
        current.append(dest);
      }
    }
  }

  public static void main(String[] args) {

  }
}
