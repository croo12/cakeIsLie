package com.elses.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {

static int n;
static int[] ingredi = {1,2,3,4};
static int[] visited = new int[n/2];
public static void main(String[] args) throws NumberFormatException, IOException {

    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for(int t =1; t<=T; t++) {
        n = Integer.parseInt(br.readLine());
        select(0,0);
    }
    
    
} // main


static void select(int idx, int vidx) {
    if(vidx == n/2){
        // 음식 맛 구하기
        System.out.println(Arrays.toString(visited));
        return;
    } else if(idx == n) return; 
    
    visited[vidx] = ingredi[idx];
    select(idx+1, vidx+1);
    select(idx+1, vidx);
}
}