package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SupplyFurnace_dijkstra {
	static class Pair implements Comparable<Pair>{
		int r,c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Pair o) {
			return dist[this.r][this.c] - dist[o.r][o.c];
		}
	}
	
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			
			int[] dr = {0,0,-1,1};
			int[] dc = {1,-1,0,0};
			
			boolean[][] vis = new boolean[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			PriorityQueue<Pair> pq = new PriorityQueue<>();
			pq.add(new Pair(0, 0));
			
			dist[0][0] = 0;
			
			while(!pq.isEmpty()) {
				Pair now = pq.poll();
				
				if(vis[now.r][now.c])
					continue;
				vis[now.r][now.c] = true;
				
				for (int k = 0; k < 4; k++) {
					int rr = now.r + dr[k];
					int rc = now.c + dc[k];
					
					if(rr >= N || rc >= N || rr < 0 || rc < 0 || vis[rr][rc]) continue;
					
					if(dist[rr][rc] > dist[now.r][now.c] + arr[rr][rc]) {
						dist[rr][rc] = dist[now.r][now.c] + arr[rr][rc];
						pq.offer(new Pair(rr,rc));
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,dist[N-1][N-1]);
		}
	}
}

