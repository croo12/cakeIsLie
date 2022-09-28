package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Fire4179 {
	//틀린이유 -> 서있는 J를 불이 덮치면 실패해야함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[R][C];
		
		Queue<Pair> q = new ArrayDeque<>();
		boolean[][] vis = new boolean[R][C];
		
		int sr = -1;
		int sc = -1;
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if(arr[i][j] == 'J') {
					sr = i;
					sc = j;
				}else if(arr[i][j] == 'F') {
					q.offer(new Pair(i,j,0,true));
					vis[i][j] = true;
				}
			}
		}
		
		q.offer(new Pair(sr,sc,1,false));
		vis[sr][sc] = true;
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int rr = now.r + dr[i];
				int rc = now.c + dc[i];
				
				if(rr >= R || rc >= C || rr < 0 || rc < 0) {
					if(now.isFire) continue;
					else { 
						System.out.println(now.num);
						return;
					}
				}
				if(vis[rr][rc] || arr[rr][rc] == '#') continue;
				
				q.offer(new Pair(rr,rc,now.num+1,now.isFire));
				vis[rr][rc] = true;
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
	
	static class Pair{
		int r,c,num;
		boolean isFire;
		Pair(int r, int c, int num, boolean isFire){
			this.r = r;
			this.c = c;
			this.num = num;
			this.isFire = isFire;
		}
	}
}
