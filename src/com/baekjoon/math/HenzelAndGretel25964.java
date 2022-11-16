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
  long[] factorial;

  int[][] compMemo;

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // N개의 카드
    int N = Integer.parseInt(st.nextToken());
    // K개의 칸
    int K = Integer.parseInt(st.nextToken());

    // 헨젤이 놓는 경우 n P k
    // 그레텔이 놓는 경우는 어케 구함?
    // (헨젤이 놓은 경우의 수 - 헨젤과 수가 겹치는 경우의 수)

    // 수가 겹치는 경우의 수는 헨젤이 놓은 K개의 수 중
    // 적어도 하나를 고른 뒤 나머지를 고르는 경우의 수의 합집합

    // = K개 중 하나를 고른 경우의 수 - 두개를 고른 경우의 수
    // + .... + 2n - 1개를 고른 경우 - 2n개를 고른 경우...

    factorial = new long[N + 1];
    factorial[0] = 1;
    for (int i = 1; i <= N; i++) {
      factorial[i] = (factorial[i - 1] * i) % MOD;
    }

    // 그레텔이 고르는 경우의 수
    // 1. k C 1 ~ k C k 까지 값을 구한다
    // 뒤에가 홀수면 더하고 짝수면 뺀다

    // k P r => k! / ( k - r)!
    // => k! * (k - r)! ^ (MOD - 2)

    // k C r => k! / { (r!) * (k - r)!}
    // => k! * ((k - r)! * r!) ^ (MOD - 2)

    long henzel = factorial[N] * pow(factorial[N - K], MOD - 2) % MOD;
    long gretel = getGretel(N, K);

    // System.out.printf("henzel : %d , gretel : %d\n", henzel, gretel);

    long ans = henzel * (henzel - gretel) % MOD;
    System.out.println(ans);
  }

  // n 내가 가진 카드
  // k 가야하는 길
  private long getGretel(int n, int k) {

    long sum = 0;
    int op = 1;

    for (int i = 1; i <= k; i++) {
      // k C i * n-i P k-i
      // k! / (k-i)! * i!
      // n! / ((n - i) - (k-i))!
      sum += (((factorial[k] * pow((factorial[k - i] * factorial[i] % MOD), MOD - 2)) % MOD)
          * (factorial[n - i] * pow(factorial[n - k], MOD - 2) % MOD))
          % MOD * op;

      sum %= MOD;

      // System.out.printf("select : %d, sum : %d\n", i, sum);

      op *= -1;
    }

    return sum;
  }

  private long pow(long val, int time) {
    // if (powMemo[(int) val][time] != 0) {
    // return powMemo[(int) val][time];
    // }

    if (time == 0)
      return 1;
    if (time == 1)
      return val;

    long half = pow(val, time / 2);

    if (time % 2 == 0)
      return
      // powMemo[(int) val][time] =
      half * half % MOD;
    else
      return
      // powMemo[(int) val][time] =
      ((half * half) % MOD) * val % MOD;
  }

}
