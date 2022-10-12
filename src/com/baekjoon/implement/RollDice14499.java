package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollDice14499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dice = {0,0,0,0,0,0};
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		
		int[][] arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(st.nextToken()) - 1;
			
			int rr = r + dr[order];
			int rc = c + dc[order];
			
			if(rr >= R || rr < 0 || rc >= C || rc < 0) continue;
			
			int tmp = 0;
			//0123 -> 우좌상하
			switch(order) {
			
			case 0:
				tmp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[2];
				dice[2] = tmp;
				break;
			case 1:
				tmp = dice[0];
				dice[0] = dice[2];
				dice[2] = dice[3];
				dice[3] = dice[1];
				dice[1] = tmp;
				break;
			case 2:
				tmp = dice[0];
				dice[0] = dice[5];
				dice[5] = dice[3];
				dice[3] = dice[4];
				dice[4] = tmp;
				break;
			case 3:
				tmp = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[3];
				dice[3] = dice[5];
				dice[5] = tmp;
			}
			r = rr;
			c = rc;
			if(arr[r][c] == 0) {
				arr[r][c] = dice[0];
			}else {
				dice[0] = arr[r][c];
				arr[r][c] = 0;
			}
			
			sb.append(dice[3]).append('\n');
		}
		System.out.print(sb);
	}
}
