package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape3055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] vis = new boolean[R][C];
		
		Queue<Pair> q = new ArrayDeque<>();
		String s;
		char c;
		
		int hr = -1;
		int hc = -1;
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				c = s.charAt(j);
				map[i][j] = c;
				if(c == '*') {
					q.offer(new Pair(i, j, false, 0));
					vis[i][j] = true;
				}else if(c == 'S') {
					hr = i;
					hc = j;
				}
			}
		}
		
		//불이야!! 랑 같은 문제 아닌가
		
		q.offer(new Pair(hr, hc, true, 0));
		vis[hr][hc] = true;
		
		int[] dr = {0,0,-1,1};
		int[] dc = {1,-1,0,0};
		
		Pair now;
		int ans = -1;
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(now.hog && map[now.r][now.c] == 'D') {
				ans = now.num;
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int rr = now.r + dr[k];
				int rc = now.c + dc[k];
				
				if(rr >= R || rr < 0 || rc >= C || rc < 0 || map[rr][rc] == 'X' || vis[rr][rc])
					continue;
				
				if(map[rr][rc] == 'D' && !now.hog)
					continue;
				
				vis[rr][rc] = true;
				q.offer(new Pair(rr, rc, now.hog, now.num + 1));
			}
		}
		
		if(ans == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(ans);
	}
	
	static class Pair{
		int r, c, num;
		boolean hog;
		Pair(int r, int c, boolean hog, int num){
			this.r = r;
			this.c = c;
			this.hog = hog;
			this.num = num;
		}
	}
}
