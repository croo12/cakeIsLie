package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sheep3184 {
    public static void main(String[] args) {
        try {
            new Sheep3184().solution();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int R, C;
    int totalSheep, totalWolf;
    int tmpSheep, tmpWolf;
    char[][] map;

    private void solution() throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        String s;
        for (int i=0; i < R; i++){
            s = br.readLine();
            for (int j=0; j < C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for (int i=0; i < R; i++){
            for (int j = 0; j < C; j++) {
                tmpSheep = 0;
                tmpWolf = 0;
                dfs(i, j);
                if( tmpSheep > tmpWolf)
                    totalSheep += tmpSheep;
                else
                    totalWolf += tmpWolf;
            }
        }

        System.out.printf("%d %d\n",totalSheep, totalWolf);
    }

    int[] dr = {0,0,-1,1};
    int[] dc = {-1,1,0,0};
    private void dfs(int r, int c){
        if( r >= R || r < 0 || c >= C || c < 0)
            return;

        char now = map[r][c];

        if( now == '#' )
            return;
        if( now == 'o')
            tmpSheep++;
        if( now == 'v')
            tmpWolf++;

        map[r][c] = '#';

        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i]);
        }
    }
}
