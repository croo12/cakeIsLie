package com.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DogMuscleAward1563 {
    public static void main(String[] args) {
        new DogMuscleAward1563().solution();
    }

    int N;
    int[][] cache;
    final int MOD = 1_000_000;
    final int INF = -1;

    private void solution() {
        input();

        //3^N 만큼의 경우의 수가 있다
        int ans = dfs(0, 0, false);

        System.out.println(ans);
    }

    private int dfs(int idx, int seq, boolean flag) {
        if ( idx == N ) {
            return 1;
        }

        int cacheNumber = seq + (flag ? 3 : 0);

        if ( cache [idx][cacheNumber] != INF) {
            return cache[idx][cacheNumber];
        }

        int value = 0;

        //결석하기
        if ( seq < 2 )
            value += dfs(idx+1, seq+1, flag);

        //지각하기
        if ( !flag )
            value += dfs(idx+1, 0, true);

        //출석하기
        value += dfs(idx+1, 0, flag);


        return cache[idx][cacheNumber] = value % MOD;
    }

    private void input() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        try {

            N = Integer.parseInt(br.readLine());

            cache = new int[N][6];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 6; j++) {
                    cache[i][j] = INF;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
