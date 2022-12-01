package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CoupleMaking1727_3 {
  public static void main(String[] args) {
    try {
      new CoupleMaking1727_3().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int MALE = Integer.parseInt(st.nextToken());
    int FEMALE = Integer.parseInt(st.nextToken());

    boolean isMinus = MALE > FEMALE;

    // 만약 모든 경우의 수를 다 조사한다면 1000!

  }
}