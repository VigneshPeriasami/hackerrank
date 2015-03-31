package com.github.vignesh_iopex.algorithm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class HackerRank {

  public int countUneatenLeaves(int N, int[] arr) {
    Set<Integer> eatenLeaves = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      int multiplier = 2;
      eatenLeaves.add(arr[i]);
      while (arr[i] * multiplier <= N) {
        eatenLeaves.add(arr[i] * multiplier);
        multiplier++;
      }
    }
    return N - eatenLeaves.size();
  }

  public static void main(String[] args) {
    try {
      HttpURLConnection conn = (HttpURLConnection) new URI("http://10.20.253.64:3005/").toURL().openConnection();
      System.out.println("connected - " + conn.getResponseCode());
      conn.getInputStream();
    } catch (FileNotFoundException e) {
      System.out.println("File not found exception");
    } catch (IOException e) {
      System.out.println("Couldn't connect");
    } catch (URISyntaxException e) {
      System.out.println("Unsupported uri");
    }
  }

}
