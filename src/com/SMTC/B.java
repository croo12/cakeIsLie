package com.SMTC;

import java.util.Scanner;
import java.util.stream.Stream;

public class B {
    public static void main(String[] args) {
        new B().solution();
    }

    int R, C;
    boolean[][] map;
    private void solution() {
        var sc = new Scanner(System.in);
        var RC = sc.nextLine();

        R = RC.charAt(0) - '0'; C = RC.charAt(2) - '0';
        map = new boolean[R][C];

        String line;
        for (int i = 0; i < R; i++) {
            line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j*2) == '1';
            }
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if( !map[i][j] ){
                    ans++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(ans);
    }

    int[] dr = {0,0,-1,1};
    int[] dc = {1,-1,0,0};
    private void dfs(int i, int j) {
        if( i == 0 )
            i = R - 1;
        else if( i == R)
            i = 0;

        if( j == 0)
            j = C - 1;
        else if( j == C)
            j = 0;

        if( map[i][j] )
            return;

        map[i][j] = true;

        int rr, rc;
        for (int k=0; k < 4; k++){
            rr = i + dr[k];
            rc = j + dc[k];

            dfs(rr, rc);
        }
    }
}