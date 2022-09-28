package com.swea.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class MountainRoad_bfs {
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					max = Math.max(arr[i][j] = Integer.parseInt(st.nextToken()), max);
				}
			}
			
			Queue<Pair> q = new ArrayDeque<>();
			
			int[] dr = {0,0,1,-1};
			int[] dc = {1,-1,0,0};
			
			int longest = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == max) {
						q.offer(new Pair(i,j,max));
					}
				}
			}
			
			while(!q.isEmpty()) {
				Pair now = q.poll();
//				System.out.printf("현재 좌표 : %d , %d ..... 현재 등산로 길이  : %d\n",now.r,now.c,now.num);
				
				longest= Math.max(longest, now.num);
				int nowHeight = now.height;
				
				for (int k = 0; k < 4; k++) {
					int rr = now.r + dr[k];
					int rc = now.c + dc[k];
					
					if(rr >= N || rc >= N || rr <0 || rc < 0 || now.vis[rr][rc]) continue;
					
					if(arr[rr][rc] < nowHeight) {
						q.add(new Pair(rr,rc, now.num + 1, now.dig, arr[rr][rc], now.vis));
					}else if(now.dig == 0 && arr[rr][rc] - K < nowHeight){
						q.add(new Pair(rr,rc, now.num + 1, 1 , nowHeight - 1,now.vis));
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,longest);
		}
		
	}
	
	static class Pair{
		int r,c;
		int num;
		int height;
		int dig; //0 false, 1 true;
		boolean[][] vis;
		
		Pair(int r, int c, int height){
			this.r = r;
			this.c = c;
			this.height = height;
			num = 1;
			vis = new boolean[N][N];
			vis[r][c] = true;
		}
		Pair(int r, int c, int num, int dig , int height, boolean[][] vis){
			this.r = r;
			this.c = c;
			this.num = num;
			this.dig = dig;
			this.height = height;
			this.vis = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				this.vis[i] = vis[i].clone();
			}
			this.vis[r][c] = true;
		}
		
		@Override
		public String toString() {
			return "[ " + r + " , " + c + " ] ";
		}
	}
}
