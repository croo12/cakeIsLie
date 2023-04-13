package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class PickUpStone25378 {
    public static void main(String[] args) {
        new PickUpStone25378().solution();
    }

    int N;
    int[] arr;
    int[] cache;
    final int INF = 987_654_321;

    private void solution() {
        input();

        cache = new int[N];
        for ( int i = 0; i < N; i++){
            cache[i] = INF;
        }

        int ans = dfs(0, 0);

        System.out.println(ans);
    }

    private int dfs(int depth, int minus) {
        if ( depth == N - 1) {
            return 1;
        }

        int nowMe = arr[depth] - minus;

        if ( nowMe == 0) {
            return dfs(depth + 1, 0);
        }
        else if  (nowMe > 0 ) {
            int patternA = dfs(depth + 1, nowMe) + 1;
            int patternB = dfs(depth + 1, 0) + 1;

            return Math.min(patternA, patternB);
        }
        else {
            //있을 수 없는 일이야....
            return INF;
        }
    }

    private void input() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            arr = Stream.of(br.readLine().split(" "))
                        .mapToInt(s -> Integer.parseInt(s))
                        .toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
