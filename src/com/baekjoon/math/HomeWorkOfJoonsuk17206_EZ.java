package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HomeWorkOfJoonsuk17206_EZ {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] ans = new int[80_001];
    int num = 0;

    for (int i = 1; i <= 80_000; i++) {
      if (i % 3 == 0 || i % 7 == 0) {
        num += i;
      }
      ans[i] = num;
    }

    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (N-- > 0) {
      int max = Integer.parseInt(st.nextToken());

      sb.append(ans[max]).append('\n');
    }

    System.out.print(sb);
  }
}
