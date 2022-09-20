package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MovingKnight7562 {
	
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ans = new int[N];
		for (int tc = 0; tc < N; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			
			Queue<KnightPosition> q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			KnightPosition start = new KnightPosition(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			q.add(start);
			visited[start.y][start.x] = true;
			
			int[] rx = {1,1,-1,-1,-2,-2,2,2};
			int[] ry = {2,-2,2,-2,1,-1,1,-1};
			
			while(!q.isEmpty()) {
				KnightPosition now = q.poll();
				
				for (int k = 0; k < 8; k++) {
					int nextX = now.x + rx[k];
					int nextY = now.y + ry[k];
					if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
						continue;
					}		
					else if(!visited[nextY][nextX]) {
						board[nextY][nextX] = board[now.y][now.x]+1;
						visited[nextY][nextX] = true;
						q.add(new KnightPosition(nextX, nextY));
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			
//			for(int[] line : board) {
//				for(int i : line) System.out.print(i+" ");
//				System.out.println();
//			}
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ans[tc] = board[y][x];
		}
		
		for (int i : ans) {
			System.out.println(i);
		}
	}
}

class KnightPosition{
	int x;
	int y;
	public KnightPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}