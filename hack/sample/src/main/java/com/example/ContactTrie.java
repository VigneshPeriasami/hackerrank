package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContactTrie {
  private static HashMap<Character, Integer> charIntMap = new HashMap<>();

  private static class Trie {
    char value;
    Trie[] nodes = new Trie[26];

    @Override
    public String toString() {
      return value + " -> " + Arrays.toString(nodes);
    }
  }

  public static void main(String[] args) {
    String testTrie = "Hello".toLowerCase();
    Trie root = new Trie();
    addToTrie(root, testTrie);
    System.out.println(findPartial(root, "hewl"));
  }

  private static void addToTrie(Trie root, String value) {
    addCharacters(root, value.toCharArray(), 0);
  }

  private static String findPartial(Trie root, String value) {
    return findPartial(root, value.toCharArray(), 0, "");
  }

  private static List<String> findSuggestions(Trie root, String value) {

  }

  private static Trie findLastMatchNode(Trie current, char[] value, int index, String partial) {
    if (index >= value.length) {
      return current;
    }
    int charIndex = toCharIndex(value[index]);
    if (current.nodes[charIndex] != null) {
      partial += current.nodes[charIndex].value;
      return findLastMatchNode(current.nodes[charIndex], value, ++index, partial);
    } else {
      return current;
    }
  }

  private static String findPartial(Trie current, char[] value, int index, String partial) {
    if (index >= value.length) {
      return partial;
    }
    int charIndex = toCharIndex(value[index]);
    if (current.nodes[charIndex] != null) {
      partial += current.nodes[charIndex].value;
      return findPartial(current.nodes[charIndex], value, ++index, partial);
    } else {
      return partial;
    }
  }

  private static void addCharacters(Trie current, char[] charArr, int index) {
    if (index >= charArr.length) {
      return;
    }
    int charIndex = toCharIndex(charArr[index]);
    Trie charNode = getCharNode(current, charIndex);
    charNode.value = charArr[index];
    addCharacters(charNode, charArr, ++index);
  }

  private static Trie getCharNode(Trie parent, int charIndex) {
    if (parent.nodes[charIndex] == null) {
      parent.nodes[charIndex] = new Trie();
    }
    return parent.nodes[charIndex];
  }

  private static int toCharIndex(char c) {
    if (!charIntMap.isEmpty()) {
      return charIntMap.get(c);
    }
    char[] characters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    for (int i = 0; i < characters.length; i++) {
      charIntMap.put(characters[i], i);
    }
    return charIntMap.get(c);
  }
}
