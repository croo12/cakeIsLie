package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Down1520 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = -1;
			}
		}
		
		int ans = up(R-1, C-1);
		
		System.out.println(ans);
	}
	
	static int R;
	static int C;
	
	static int[][] arr;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int[][] map;
	
	static int up(int r, int c) {
		if(r == 0 && c == 0)
			return 1;
		
		if(map[r][c] != -1)
			return map[r][c];
		
		int sum = 0;
		for (int k = 0; k < 4; k++) {
			int rr = r + dr[k];
			int rc = c + dc[k];
			
			if(rr < 0 || rc < 0 || rr >= R || rc >= C || arr[rr][rc] <= arr[r][c]) continue;
			
			sum += up(rr,rc);
		}
		
		return map[r][c] = sum;
	}
}
