package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bishop1799_ver3 {
    static class Pair {
        int x;
        int y;
    }

static int cnt;
static ArrayList<Pair> list = new ArrayList<>();

static void bts(int x, int y) {
    for (int i = 0; i < 18; i++) {
        if (x + dr[i] < 0 || y + dc[17 - i] < 0 || y + dc[i] < 0 || x + dr[i] >= n ||
                y + dc[17 - i] >= n || y + dc[i] >= n) {
            continue;
        }
        if(visited[x + dr[i]][y + dc[i]] || visited[x + dr[i]][y + dc[17 - i]]){
            return;
        }
    }
    cnt++;
    System.out.println(cnt);
}

static void bishop(int start) {
    if(start==list.size())
        return;
    visited[list.get(start).x][list.get(start).y] = true;
    bts(list.get(start).x, list.get(start).y);
    bishop(start + 1);
}
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                visited[i][j] = true;
//                bts(i, j);
//                bishop();
//                visited[i][j] = false;
//            }
//        }

static int[][] arr;
static int n;
static boolean[][] visited;
static boolean[] ved;
static int[] dr = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
static int[] dc = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};

public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    arr = new int[n][n];
    visited = new boolean[n][n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
        st = new StringTokenizer(bf.readLine());
        for (int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
            if (arr[i][j] == 1) {
            	Pair pair = new Pair();
                pair.x = i;
                pair.y = j;
                list.add(pair);
            }
        }
    }
//        ved = new boolean[list.size()];
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            bishop(i);
            max = Math.max(max, cnt);
            cnt = 0;
            for(int j=0; i<n; i++){
                for(int k=0; k<n ;k++){
                    visited[j][k]=false;
                }
            }
        }
        System.out.println(max);
    }
}