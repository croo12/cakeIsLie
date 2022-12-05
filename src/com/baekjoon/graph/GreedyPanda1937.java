package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GreedyPanda1937 {
	public static void main(String[] args) {
		try {
			new GreedyPanda1937().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int N;
	int[][] map;
	int[][] cache;
	
	int ans;
	
	int[] dr = {1,-1,0,0};
	int[] dc = {0,0,-1,1};
	
	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cache = new int[N][N];
		
		String[] tmp;
		//지도 만들기
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				cache[i][j] = -1;
			}
		}
		
		//정답
		ans = 0;
		
		//완전탐색하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//간 적 없음
				if(cache[i][j] == -1) {
					ans = Math.max( 1 + dfs(i,j,1) , ans );
				}
				
			}
		}
		
		System.out.println(ans);
		
	}

	private int dfs(int row, int col, int cnt) {
		
		int max = 0;
		
		//4방 탐색
		int rr, rc;
		for (int i = 0; i < 4; i++) {
			rr = row + dr[i];
			rc = col + dc[i];
			
			if(rr < 0 || rc < 0 || rr >= N || rc >= N) 
				continue;
			
			//나보다 많음
			if(map[rr][rc] > map[row][col] ) {
				//기록 있음?
				if(cache[rr][rc] != -1) {
					max = Math.max(max, 1 + cache[rr][rc]);
				}else {
					max = Math.max(max, 1 + dfs(rr, rc, cnt+1));
				}
				
			}
		}
		
		return cache[row][col] = max;
	}
}
