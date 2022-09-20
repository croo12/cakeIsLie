package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snake3190 {
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dos = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			dos[y-1][x-1] = -1;
		}
		
		int dir = 100;
		int t = 0;
		
		int taleX = 0;
		int taleY = 0;
		
		int nowX = 0;
		int nowY = 0;
		
		dos[0][0] = 1;
		
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int dt = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			
			for (t++; t <= dt; t++) {
				nowX += dx[dir%4];
				nowY += dy[dir%4];
				
				if(nowY < 0 || nowX < 0 || nowY >= N || nowX >= N) {
					System.out.println(t);
					return;
				}
				if(dos[nowY][nowX] > 0) {
					System.out.println(t);
					return;
				}
				
				if(dos[nowY][nowX] != -1) {
					int now = dos[taleY][taleX];
					dos[taleY][taleX] = 0;
					taleX += dx[now-1];
					taleY += dy[now-1];
				}
				
				if(t==dt) {
					if(d.equals("D"))
						dir++;
					else
						dir--;
				}
				dos[nowY][nowX] = dir%4 + 1;
			}
			t--;
			
		}
		
		while (t++ > 0) {
			nowX += dx[dir%4];
			nowY += dy[dir%4];
			
			if(nowY < 0 || nowX < 0 || nowY >= N || nowX >= N) {
				System.out.println(t);
				return;
			}
			if(dos[nowY][nowX] > 0) {
				System.out.println(t);
				return;
			}
			
			if(dos[nowY][nowX] != -1) {
				int now = dos[taleY][taleX];
				dos[taleY][taleX] = 0;
				taleX += dx[now-1];
				taleY += dy[now-1];
			}
			
			dos[nowY][nowX] = dir%4 + 1;
		}
	}
}
