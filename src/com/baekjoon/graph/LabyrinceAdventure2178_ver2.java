package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LabyrinceAdventure2178_ver2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+2][M+2];
		
		String line;
		for (int i = 1; i < N+1; i++) {
			line = br.readLine();
			for (int j = 1; j < M+1; j++) {
				map[i][j] = line.charAt(j-1) - '0';
			}
		}
	
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.add(new Pair(1,1));
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(q.size()!=0) {
			Pair now = q.poll();
			
			for(int k =0; k < 4; k++) {
				int nextX = now.x + dx[k];
				int nextY = now.y + dy[k];
				if(map[nextY][nextX] == 1) {
					map[nextY][nextX] += map[now.y][now.x];
					q.add(new Pair(nextX,nextY));
				}
			}
		}
		//시작 위치가 3으로 변하지만 상관없음
		
		System.out.println(map[N][M]);
	}
	static class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}



