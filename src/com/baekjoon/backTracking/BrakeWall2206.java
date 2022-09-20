package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BrakeWall2206 {
	
	static int[][] arr;
	static boolean[][] vis;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int min = 1000000;
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr =new int[N][M];
		List<Pair> walls = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
				if(arr[i][j] == 1) {
					walls.add(new Pair(j,i,0));
				}
			}
		}
		
		Pair now;
		if(walls.size() != 0)
			for (int i = 0; i < walls.size(); i++) {
				vis = new boolean[N][M];
				now = walls.get(i);
				arr[now.y][now.x] = 0;
				bfs();
				arr[now.y][now.x] = 1;
			}
		else
			min = N+M-1;
		
		if(min == 1000000) System.out.println(-1);
		else System.out.println(min);
	}
	
	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0,0,1));
		vis[0][0] = true;
		
		Pair now;
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(now.x == M-1 && now.y == N-1) {
				min = Math.min(now.num, min);
			}
			
			if(now.num >= min) return;
			
			for (int k = 0; k < 4; k++) {
				int rx = now.x + dx[k];
				int ry = now.y + dy[k];
				
				if(rx >= M || ry >= N || rx < 0 || ry < 0) continue;
				if(!vis[ry][rx] && arr[ry][rx] == 0) {
					vis[ry][rx] = true;
					q.offer(new Pair(rx,ry,now.num+1));
				}
			}
		}
		
	}
	
	static class Pair{
		int x;
		int y;
		int num;
		Pair(int x, int y, int num){
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
