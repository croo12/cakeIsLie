package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간초과로 답 안나오지만 계산은 성공함

public class HomeWorkOfJoonsuk17206_Practice {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    boolean[] num3 = new boolean[80_001];
    boolean[] num7 = new boolean[80_001];

    for (int i = 1; i <= 80_000; i++) {
      if (i % 3 == 0)
        num3[i] = true;
      if (i % 7 == 0)
        num7[i] = true;
    }

    // int[] ans = pab(num3, num7);

    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (N-- > 0) {
      int max = Integer.parseInt(st.nextToken());
      sb.append(pab(max, num3, num7)).append('\n');
    }

    System.out.print(sb);
  }

  private static int pab(int max, boolean[]... unions) {
    int n = unions.length;

    int sum = 0;
    for (int i = 1; i <= n; i++) {
      check = new int[i];
      sum += select(max, i, unions, 0, 0) * ((i % 2 == 0) ? -1 : 1);
    }

    return sum;
  }

  static int[] check;

  private static int select(int len, int max, boolean[][] unions, int now, int last) {
    if (now == max) {
      int result = 0;

      for (int i = 0; i <= len; i++) {
        boolean flag = true;
        for (int j : check) {
          if (!unions[j][i]) {
            flag = false;
            break;
          }

        }
        if (flag) {
          result += i;
        }
      }

      return result;
    }

    if (last == unions.length)
      return 0;

    int sum = 0;

    for (int i = last; i < unions.length; i++) {
      check[now] = i;
      sum += select(len, max, unions, now + 1, i + 1);
    }

    return sum;
  }
}
