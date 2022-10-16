package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureIsland2589 {
	//틀린이유
	//1. 해안가 체크를 반대로 함
	//2. 그리고 바다에서도 출발함 ㅋㅋㅋ
	
	static int R;
	static int C;
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[R][C];
		
		String s;
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) == 'L';
			}
		}
		
		//이어져 있으면서 가장 거리가 먼 두 점을 찾는 문제
		//간단하게 생각해보면 모든 지점 돌면서 bfs하면 가능함
		//50*50 을 전부 bfs 돌기, 1초안에 가능할까?
		
		//가지치기의 가능성이 있는가?
		//1. 당연히 보물이 있는 곳은 해안가에 있는 두 점일 것이다.
		
		//일단 해안가만 갖고 해보자
		
		Queue<Pair> q = new ArrayDeque<>(1250);
		boolean[][] vis;
		Pair now;
		
		int dist = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!map[i][j])
					continue;
				
				//해안가임?
				boolean flag = false;
				for (int k = 0; k < 4; k++) {
					int rr = i + dr[k];
					int rc = j + dc[k];
					
					if(!check(rr,rc) || !map[rr][rc]) {
						flag = true;
						break;
					}
				}
				
				//거리 재기
				if(flag) {
					vis = new boolean[R][C];
					
					q.offer(new Pair(i,j,0));
					vis[i][j] = true;
					
					while(!q.isEmpty()) {
						now = q.poll();
						
						dist = Math.max(now.num, dist);
						
						for (int k = 0; k < 4; k++) {
							int rr = now.r + dr[k];
							int rc = now.c + dc[k];
							
							if(check(rr,rc) && !vis[rr][rc] && map[rr][rc]) {
								vis[rr][rc] = true;
								q.offer(new Pair(rr,rc,now.num+1));
							}
						}
					}
				}
			}
		}
		
		System.out.println(dist);
	}
	
	static boolean check(int r, int c) {
		return r < R && r >= 0 && c < C && c >= 0;
	}
	
	static class Pair{
		int r,c,num;

		Pair(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
}
