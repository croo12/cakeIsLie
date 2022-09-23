package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafetyZone2468 {
	
	static int SNUM;
	static int n;
	
	static int[][] arr;
	static boolean[][] vis;
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		
		int max = 0;
		int min = 101;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int now = Integer.parseInt(st.nextToken());
				arr[i][j] = now;
				max = Math.max(now, max);
				min = Math.min(now, min);
			}
		}
		
		int ans = 0;
		
		while(max >= min) {
			SNUM = max;
			int cnt = 0;
			vis = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!vis[i][j] && arr[i][j] >= SNUM) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			
			ans = Math.max(ans,cnt);
			
			max--;
		}
		
		System.out.println(ans);
	}
	
	private static void dfs(int r, int c) {
		vis[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int rr = r + dr[i];
			int rc = c + dc[i];
			
			if(rr >= n || rc >= n || rr < 0 || rc < 0) continue;
			if(vis[rr][rc] || arr[rr][rc] < SNUM) continue;				
			
			dfs(rr,rc);
		}
	}
}
