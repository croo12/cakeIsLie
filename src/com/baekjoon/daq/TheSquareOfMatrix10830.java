package com.baekjoon.daq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * TheSquareOfMatrix10830
 */
public class TheSquareOfMatrix10830 {
  public static void main(String[] args) {
    try {
      new TheSquareOfMatrix10830().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  int N;

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    int[][] arr = new int[N][N];

    for (int i = 0; i < arr.length; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < arr.length; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // matrixCalc(arr);
    int[][] ans = pow(arr, B);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(ans[i][j] % 1000 + " ");
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }

  private int[][] pow(int[][] arr, long b) {
    if (b == 1) {
      return arr;
    }

    int[][] half = pow(arr, b / 2);

    if (b % 2 == 0) {
      return matrixCalc(half, half);
    } else {
      return matrixCalc(matrixCalc(half, half), arr);
    }

  }

  private int[][] matrixCalc(int[][] arr, int[][] arr2) {
    int[][] tmp = new int[N][N];

    int sum;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sum = 0;

        for (int k = 0; k < N; k++) {
          sum += arr[i][k] * arr2[k][j];
        }

        tmp[i][j] = sum % 1000;
      }
    }

    return tmp;
  }
}