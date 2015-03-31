package com.github.vignesh_iopex.tests;

import com.github.vignesh_iopex.algorithm.HackerRank;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HackerRankTest {
  @Test public void getEatenLeaves() {
    HackerRank hackerRank = new HackerRank();
    int result = hackerRank.countUneatenLeaves(10, new int[] {2, 4, 5});
    assertThat(result).isEqualTo(4);
  }
}
