package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Down_ver2_1520 {
	//상향식에 문제가 있다.
	//바로 높이가 같은경우 이새끼가 옆에있는 녀석을 먹어버린다는 것이다
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] arr = new int[R][C];
		
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
			}
		}
		
		boolean[][] vis = new boolean[R][C];
		
		pq.offer(new Pair(0,0,map[0][0]));
		
		arr[0][0] = 1;
		vis[0][0] = true;
		
		while(!pq.isEmpty()) {
			Pair now = pq.poll();
			
			for (int k = 0; k < 4; k++) {
				int rr = now.r + dr[k];
				int rc = now.c + dc[k];
				
				if(rr >= R || rc >= C || rr < 0 || rc < 0 || map[rr][rc] >= map[now.r][now.c]) continue;
				
				arr[rr][rc] += arr[now.r][now.c];
				if(!vis[rr][rc]) {
					pq.offer(new Pair(rr,rc,map[rr][rc]));
					vis[rr][rc] = true;
				}
			}

			if(now.r == R-1 && now.c == C-1)
				break;
		}
		
		System.out.println(arr[R-1][C-1]);
	}
	
	static class Pair implements Comparable<Pair>{
		int r,c,height;
		
		Pair(int r, int c, int height){
			this.r = r;
			this.c = c;
			this.height = height;
		}
		
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(o.height,this.height);
		}
	}
}
