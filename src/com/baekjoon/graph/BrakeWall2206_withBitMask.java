package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BrakeWall2206_withBitMask {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr =new int[N][M];
		int[][] visRalph = new int[N][M]; //0 1 2 3
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		
		Queue<Ralph> q = new ArrayDeque<Ralph>();
		q.offer(new Ralph(0,0,1));
		visRalph[0][0] = 1;
		
		while(!q.isEmpty()) {
			Ralph now = q.poll();
			
			if(now.r == N-1 && now.c == M-1) {
				System.out.println(now.num);
				return;
			}
			
			for (int k = 0; k < 4; k++) {
				int rr = now.r + dr[k];
				int rc = now.c + dc[k];
				
				if(rr >= N || rc >= M || rr < 0 || rc < 0) continue;
				
				if(now.fatigue) { //주먹 씀?
					if(arr[rr][rc] == 0 && (visRalph[rr][rc] & 2) == 0) {
						visRalph[rr][rc] += 2;
						q.offer(new Ralph(rr,rc,now.num+1,true));
					}
				}else {
					if(arr[rr][rc] == 0 && (visRalph[rr][rc] & 1) == 0) {
						visRalph[rr][rc] += 1;
						q.offer(new Ralph(rr,rc,now.num+1,false));
					}
					else if(arr[rr][rc] == 1 && (visRalph[rr][rc] & 2) == 0) { //주먹 안썼는데 벽 만나면 벽 부수고 지친 랄프로 바꿈
						visRalph[rr][rc] += 2;
						q.offer(new Ralph(rr,rc,now.num+1,true));
					}
				}
			}
		}
		
		System.out.println(-1);
	}
	
	static class Ralph{
		int r;
		int c;
		int num;
		boolean fatigue;
		Ralph(int r, int c, int num){
			this.r = r;
			this.c = c;
			this.num = num;
			fatigue = false;
		}
		Ralph(int r, int c, int num, boolean fatigue){
			this.r = r;
			this.c = c;
			this.num = num;
			this.fatigue = fatigue;
		}
	}
}
