package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LabyrinceAdventure2178 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[][] visited;
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		
		String[] line;
		for (int i = 1; i < N+1; i++) {
			line = br.readLine().split("");
			for (int j = 1; j < M+1; j++) {
				map[i][j] = Integer.parseInt(line[j-1]);
			}
		}
	
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.add(new Pair(1,1));
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while(q.size()!=0) {
			Pair now = q.poll();
			visited[now.y][now.x] = true;
			
			for(int k =0; k < 4; k++) {
				int nextX = now.x + dx[k];
				int nextY = now.y + dy[k];
				if(map[nextY][nextX] == 1 && !visited[nextY][nextX]) {
					map[nextY][nextX] += map[now.y][now.x];
					q.add(new Pair(nextX,nextY));
				}
			}
		}
		
		System.out.println(map[N][M]);
	}
	
}

class Pair{
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

