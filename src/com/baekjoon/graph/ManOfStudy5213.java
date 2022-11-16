package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class ManOfStudy5213 {
  public static void main(String[] args) {
    try {
      new ManOfStudy5213().solution();
    } catch (NumberFormatException | IOException e) {
      e.printStackTrace();
    }
  }

  int[] dr = { 1, 1, -1, -1, 0, 0 };
  int[] oddDc = { -1, 0, -1, 0, -1, 1 };
  int[] evenDc = { 0, 1, 0, 1, -1, 1 };

  private void solution() throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][][] domino = new int[N + 2][N + 2][];
    int end = N * N - N / 2;
    boolean[] vis = new boolean[end + 1];
    int row = 1;
    int col = 1;
    StringTokenizer st;
    for (int i = 1; i <= end; i++) {
      st = new StringTokenizer(br.readLine());
      domino[row][col++] = new int[] { i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

      if (row % 2 == 1 && col == N + 1) {
        row++;
        col = 1;
      } else if (row % 2 == 0 && col == N) {
        row++;
        col = 1;
      }
    }

    // for (int i = 0; i < N + 2; i++) {
    // for (int j = 0; j < N + 2; j++) {
    // System.out.print(domino[i][j] + " ");
    // }
    // System.out.println();
    // }

    // System.out.println("hi");

    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(1, 1, 1, 1, null));
    vis[1] = true;

    int max = 0;
    int minLevel = end + 1;
    Node last = null;

    Node now;
    while (!q.isEmpty()) {
      now = q.poll();

      if (now.no > max) {
        max = now.no;
        minLevel = now.level;
        last = now;
      } else if (now.no == max && now.level < minLevel) {
        minLevel = now.level;
        last = now;
      }

      for (int i = 0; i < 6; i++) {
        int rr = now.r + dr[i];
        int rc;
        if (now.r % 2 == 0) {
          rc = now.c + evenDc[i];
        } else {
          rc = now.c + oddDc[i];
        }

        if (rr < 1 || rc < 1 || rr > N || rc > (rr % 2 == 0 ? (N - 1) : N))
          continue;

        boolean flag;
        if (i % 2 == 1)
          flag = (domino[now.r][now.c][2] == domino[rr][rc][1]);
        else
          flag = (domino[now.r][now.c][1] == domino[rr][rc][2]);

        int nextNum = domino[rr][rc][0];

        if (vis[nextNum] || (!flag))
          continue;

        vis[nextNum] = true;
        q.offer(new Node(rr, rc, nextNum, now.level + 1, now));
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(minLevel).append('\n');
    int[] root = new int[minLevel];

    while (last != null) {
      root[--minLevel] = last.no;
      last = last.next;
    }

    for (int i : root) {
      sb.append(i + " ");
    }
    System.out.println(sb);
  }

  class Node {
    int r, c, no, level;
    Node next;

    public Node(int r, int c, int no, int level, Node next) {
      this.r = r;
      this.c = c;
      this.no = no;
      this.level = level;
      this.next = next;
    }
  }
}
