package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Height2252 {
  public static void main(String[] args) {
    try {
      new Height2252().solution();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    // 위상정렬문제 아님?

    int[] people = new int[N + 1];
    Node[] adjList = new Node[N + 1];

    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());

      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      people[end]++;
      adjList[start] = new Node(end, adjList[start]);
    }

    StringBuilder sb = new StringBuilder();
    boolean flag = true;
    while (flag) {
      flag = false;

      for (int i = 1; i <= N; i++) {
        if (people[i] == 0) {
          flag = true;
          people[i] = -1;
          sb.append(i + " ");

          for (Node now = adjList[i]; now != null; now = now.next) {
            people[now.end]--;
          }
        }
      }
    }

    System.out.println(sb);
  }

  class Node {
    Node next;
    int end;

    public Node(int end, Node next) {
      this.end = end;
      this.next = next;
    }
  }
}
