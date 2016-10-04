package com.example;

import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {
  public static void main(String[] args) {
    BigInteger[] cache = new BigInteger[11];
    for (int i = 0; i < 10; i++) {
      System.out.println(modFibCached(i, 0, 1, cache));
    }
  }

  private static void normalTrail() {
    int[] cache = new int[10];

    for (int i = 0; i < 10; i++) {
      System.out.println(cachedNFib(i, cache));
    }
    int[] fib = new int[10];
    loadNFib(9, fib);
    System.out.println(Arrays.toString(fib));
  }

  private static int nFib(int n) {
    if (n <= 1) {
      return n;
    }
    return nFib(n - 1) + nFib((n - 2));
  }

  private static void loadNFib(int n, int[] result) {
    if (n < 0) {
      return;
    }
    result[n] = nFib(n);
    loadNFib(n - 1, result);
  }

  private static int cachedNFib(int n, int[] cache) {
    if (n >= cache.length) {
      throw new IndexOutOfBoundsException("Cache size exploded");
    }
    if (cache[n] == 0) {
      System.out.println("compute : " + n + "th fibonacci");
      if (n <= 1) {
        cache[n] = n;
        return n;
      }
      cache[n] = cachedNFib(n - 1, cache) + cachedNFib(n - 2, cache);
    }
    return cache[n];
  }

  private static BigInteger modFibCached(int n, int f, int s, BigInteger[] cache) {
    if (n == 0) {
      return BigInteger.valueOf(f);
    } else if (n == 1) {
      return BigInteger.valueOf(s);
    }

    if (cache[n] == null) {
      cache[n] = modFibCached(n - 2, f, s, cache).add(
          modFibCached(n - 1, f, s, cache).pow(2));
    }
    return cache[n];
  }
}
