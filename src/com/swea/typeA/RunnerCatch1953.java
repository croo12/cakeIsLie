package com.swea.typeA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class RunnerCatch1953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,-1,1};
		StringTokenizer st;
		Queue<Pair> q = new ArrayDeque<>();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] arr = new int[R][C];
			boolean[][] vis = new boolean[R][C];
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			q.offer(new Pair(r,c,1));
			vis[r][c] = true;
			while(!q.isEmpty()) {
				Pair now = q.poll();
				
				cnt++;

				if(now.length == time)
					continue;
				//1 -> 상하좌우	//2 -> 상하
				//3 -> 좌우		//4 -> 상우
				//5 -> 하우		//6 -> 하좌
				//7 -> 상좌
				int pipe = arr[now.r][now.c];
				//하상좌우
				for (int k = 0; k < 4; k++) {
					
					int rr = now.r + dr[k];
					int rc = now.c + dc[k];
					
					if(rr < 0 || rc < 0 || rr >= R || rc >= C || vis[rr][rc]) continue;
					
					switch(k) {
					case 0:
						if(pipe != 1 && pipe != 2 && pipe != 5 && pipe != 6)
							continue;
						else if(arr[rr][rc] != 1 && arr[rr][rc] != 2 && arr[rr][rc] != 4 && arr[rr][rc] != 7)
							continue;
						break;
					case 1:
						if(pipe != 1 && pipe != 2 && pipe != 4 && pipe != 7)
							continue;
						else if(arr[rr][rc] != 1 && arr[rr][rc] != 2 && arr[rr][rc] != 5 && arr[rr][rc] != 6)
							continue;
						break;
					case 2:
						if(pipe != 1 && pipe != 3 && pipe != 6 && pipe != 7)
							continue;
						else if(arr[rr][rc] != 1 && arr[rr][rc] != 3 && arr[rr][rc] != 4 && arr[rr][rc] != 5)
							continue;
						break;
					case 3:
						if(pipe != 1 && pipe != 3 && pipe != 4 && pipe != 5)
							continue;
						else if(arr[rr][rc] != 1 && arr[rr][rc] != 3 && arr[rr][rc] != 6 && arr[rr][rc] != 7)
							continue;
						break;
					}
					
					vis[rr][rc] = true;
					q.offer(new Pair(rr,rc,now.length+1));
				}
			}
			
			sb.append("#" + tc + " " + cnt).append('\n');
		}
		System.out.print(sb);
	}
	
	static class Pair{
		int r,c,length;
		Pair(int r, int c, int length){
			this.r = r;
			this.c = c;
			this.length = length;
		}
	}
}
