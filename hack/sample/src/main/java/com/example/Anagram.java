package com.example;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Anagram {
  public static void main(String[] args) {
    Scanner reader = new Scanner(new InputStreamReader(System.in));

    List<String> words = new LinkedList<>();

    while (reader.hasNextLine()) {
      words.add(reader.nextLine());
    }

    Collections.sort(words);
    HashMap<String, List<String>> mapped = new HashMap<>();
    for (String word : words) {
      String key = sort(word);
      store(mapped, key, word);
    }
    for (String word : words) {
      String key = sort(word);
      if (mapped.get(key) == null) {
        continue;
      }
      List<String> anagrams = mapped.get(key);
      System.out.println(join(anagrams, ","));
      mapped.put(key, null);
    }
  }

  private static void store(Map<String, List<String>> map, String key, String newValue) {
    List<String> existing = map.get(key);
    if (existing == null) {
      existing = new LinkedList<>();
      map.put(key, existing);
    }
    existing.add(newValue);
  }

  private static String join(List<String> aArr, String sSep) {
    StringBuilder sbStr = new StringBuilder();
    for (int i = 0, il = aArr.size(); i < il; i++) {
      if (i > 0)
        sbStr.append(sSep);
      sbStr.append(aArr.get(i));
    }
    return sbStr.toString();
  }

  private static String sort(String word) {
    word = word.replaceAll(" ", "");
    char[] sorted = word.toCharArray();
    Arrays.sort(sorted);
    return new String(sorted);
  }
}
