package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SafetyZone2469BFS {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		int SNUM;
		
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
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		Queue<Pair> q = new ArrayDeque<>();
		
		while(max >= min) {
			SNUM = max;
			int cnt = 0;
			boolean[][] vis = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!vis[i][j] && arr[i][j] >= SNUM) {
						q.offer(new Pair(i,j));
						cnt++;
						vis[i][j] = true;
						
						while(!q.isEmpty()) {
							Pair now = q.poll();
							
							for (int k = 0; k < 4; k++) {
								int rr = now.r + dr[k];
								int rc = now.c + dc[k];
								
								if(rr >= n || rc >= n || rr < 0 || rc < 0) continue;
								if(vis[rr][rc] || arr[rr][rc] < SNUM) continue;
								
								q.offer(new Pair(rr,rc));
								vis[rr][rc] = true;
							}
						}
					}
				}
			}
			
			ans = Math.max(ans,cnt);
			
			max--;
		}
		
		System.out.println(ans);
	}
	static class Pair{
		int r;
		int c;
		Pair(int r, int c){
			this.r =r;
			this.c =c;
		}
	}
}
