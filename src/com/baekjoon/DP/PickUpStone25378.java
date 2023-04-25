package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Stream;

public class PickUpStone25378 {
    public static void main(String[] args) {
        new PickUpStone25378().solution();
    }

    int N;
    int[] arr;
    HashMap<Integer, Integer>[] cache;
    final int INF = 987_654_321;

    private void solution() {
        input();

        cache = new HashMap[N];
        for (int i = 0; i < N; i++) {
            cache[i] = new HashMap<>();
        }

        int ans = dfs(0, 0);

        System.out.println(ans);
    }

    int dfs (int depth, int minus) {

        int now = arr[depth] - minus;

        if ( depth == N - 1) {
            if ( now == 0)
                return 0;
            else
                return 1;
        }

        if ( cache[depth].containsKey(now) ) {
            return cache[depth].get(now);
        }

        if ( now > 0 ) {
            int caseA = dfs(depth + 1, 0) + 1;
            int caseB = dfs(depth + 1, now) + 1;
            int min = Math.min(caseA, caseB);

            cache[depth].put(now, min);

            return min;
        }
        else if (now == 0) {
            int min = dfs(depth + 1, 0);

            cache[depth].put(now, min);

            return min;
        }
        else {
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
