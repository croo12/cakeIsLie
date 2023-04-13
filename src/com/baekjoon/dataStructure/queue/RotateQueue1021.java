package com.baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

public class RotateQueue1021 {
    public static void main(String[] args) {
        new RotateQueue1021().solution();
    }

    int N, M;
    int[] orders;

    private void solution() {
        Input();

        var deque = new ArrayDeque<Integer>();
        var len = N;
        var total = 0;

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        int now;
        int cnt;
        for (int i = 0; i < M; i++) {
            now = orders[i];
            cnt = 0;

            while (deque.peekFirst() != now) {
                deque.addLast(deque.pollFirst());
                cnt++;
            }

            total += Math.min(len - cnt, cnt);
            deque.pollFirst();
            len--;
        }

        System.out.println(total);
    }

    private void Input() {
        var br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int[] NM = Stream.of(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();

            N = NM[0];
            M = NM[1];

            orders = Stream.of(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
