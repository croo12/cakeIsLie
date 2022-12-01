package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javafx.scene.layout.Priority;

public class CoupleMaking1727 {
  public static void main(String[] args) {
    try {
      new CoupleMaking1727().solution();
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

    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(Math.abs(o1), Math.abs(o2));
      }
    });

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < MALE; i++) {
      pq.offer(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < FEMALE; i++) {
      pq.offer(Integer.parseInt(st.nextToken()) * -1);
    }

    int sum = 0;

    int now;
    int[] stack = new int[isMinus ? MALE : FEMALE];
    int[] best_stack = new int[isMinus ? FEMALE : MALE];

    int rear = -1;
    int best_rear = -1;

    while (!pq.isEmpty()) {
      now = pq.poll();

      if ((isMinus && now < 0) || (!isMinus && now > 0)) {
        if (best_rear != -1 && best_stack[best_rear] * now < 0) {
          sum += Math.abs(best_stack[best_rear] + now);
          continue;
        }

        int left = 1_000_001;
        if (rear != -1)
          left = Math.abs(now + stack[rear]);
        int right = Math.abs(now + pq.peek());

        if (rear != -1 && now * stack[rear] < 0 && left <= right) {
          stack[rear] = 0;
          rear--;
          sum += left;
        } else if (now * pq.peek() < 0) {
          pq.poll();
          sum += right;
        } else {
          best_stack[++best_rear] = now;
        }

      } else {
        stack[++rear] = now;
      }
    }

    System.out.println(sum);
  }
}