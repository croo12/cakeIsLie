package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MazeMaker2665 {
    public static void main(String[] args) {
        try {
            new MazeMaker2665().solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int N;
    int ans;
    boolean[][] map;
    int[][] vis;
    private void solution() throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        vis = new int[N][N];

        ans = N * N;

        String tmp;
        for (int i = 0; i < N; i++) {
            tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j) == '0';
                vis[i][j] = ans;
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans);
    }

    int[] dr = {0,0,-1,1};
    int[] dc = {1,-1,0,0};

    void dfs(int row, int col, int wall){
        //체크
        if( row < 0 || col < 0 || row >= N || col >= N || wall >= ans )
            return;

        //도착함
        if(row == N-1 && col == N-1) {
            ans = wall;
            return;
        }

        //여기 벽이야
        if(map[row][col])
            wall++;

        if(vis[row][col] <= wall)
            return;

        //vis 체크
        vis[row][col] = wall;

        //4방 탐색
        int rr,rc;
        for (int k = 0; k < 4; k++) {
            rr = row + dr[k];
            rc = col + dc[k];

            dfs(rr,rc, wall );
        }
    }
}
