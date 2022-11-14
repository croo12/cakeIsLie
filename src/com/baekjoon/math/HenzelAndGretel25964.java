package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HenzelAndGretel25964 {
  public static void main(String[] args) {
    try {
      new HenzelAndGretel25964().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 소수겠지
  final int MOD = 1_000_000_007;

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // N개의 카드
    int N = Integer.parseInt(st.nextToken());
    // K개의 칸
    int K = Integer.parseInt(st.nextToken());

    // 헨젤이 놓는 경우 n P k => n! * ((n - k)! ^ (MOD - 2)) /// MOD
    // 그레텔이 놓는 경우는 어케 구함?
    // (헨젤이 놓은 경우의 수 - 헨젤과 수가 겹치는 경우의 수)

    // 수가 겹치는 경우의 수는 헨젤이 놓은 K개의 수 중 적어도 하나를 고른 뒤 나머지를 고르는 경우의 수임
  }
}
