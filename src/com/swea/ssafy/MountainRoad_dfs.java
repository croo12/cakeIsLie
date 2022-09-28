package com.swea.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MountainRoad_dfs {
	
	static int N;
	static int K;
	static int[][] arr;
	
	static int longest;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					max = Math.max(arr[i][j] = Integer.parseInt(st.nextToken()), max);
				}
			}
			
			longest = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == max) {
						boolean[][] vis = new boolean[N][N];
						dfs(i, j, false, max, 1, vis);
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,longest);
		}
	}
	
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	
	static void dfs(int r, int c, boolean dig, int height, int depth, boolean[][] vis) {
		if(vis[r][c])
			return;
		
		boolean[][] tmp = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			tmp[i] = vis[i].clone();
		}
		tmp[r][c] = true;
		
		for (int k = 0; k < 4; k++) {
			int rr = r + dr[k];
			int rc = c + dc[k];
			
			if(rr >= N || rc >= N || rr < 0 || rc < 0 || tmp[rr][rc]) continue;
			if(arr[rr][rc] < height)
				dfs(rr,rc,dig,arr[rr][rc],depth+1,tmp);
			else if(!dig && arr[rr][rc] - K < height)
				dfs(rr,rc,true,height-1,depth+1,tmp);
		}
		
		longest = Math.max(depth, longest);
	}
}
