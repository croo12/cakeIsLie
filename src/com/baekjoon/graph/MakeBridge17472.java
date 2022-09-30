package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MakeBridge17472 {
	static int[][] arr;
	static int R;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		//일단 섬을 찾는다... -> 덩어리 구분하기
		//dfs로 다 뒤져서 숫자를 바꾸자 
		//10*10이라 스택 오버할 일 없음
		int cnt = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] == 1) {
					exploreIsland(i,j,++cnt);
				}
			}
		}
		
		
		
		
		//그리고 섬끼리 다리를 연결한다 -> 4방탐색해서 처음으로 도착하는 섬 찾으면 둘을 연결하는 다리를 만든다
		//만든 다리는 힙에 넣는다
		PriorityQueue<Road> pq = new PriorityQueue<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] != 0) {
					int st = arr[i][j];
					for (int k = 0; k < 4; k++) {
						int rr = i + dr[k];
						int rc = j + dc[k];
						
//						if(rr >= R || rc >= C || rr < 0 || rc < 0 || arr[rr][rc] != 0) continue;
						
						int length = 0;
						
						while(in(rr,rc) && arr[rr][rc] == 0) {
							length++;
							
							rr = rr + dr[k];
							rc = rc + dc[k];
						}
						
						if(in(rr,rc) && length >= 2 && arr[rr][rc] != st) {
							pq.offer(new Road(st,arr[rr][rc],length));
						}else
							continue;
					}
				}
			}
		}
		
//		System.out.println(pq);
		
		//그러면 KRUSKA로 간단히 가능
		int[] p = new int[cnt+1];
		for (int i = 2; i <= cnt; i++) {
			p[i] = i;
			//makeSet
		}
		
		//V-1개
		int ans = 0;
		int pick = 0;
		boolean flag = false;
		while(!pq.isEmpty()) {
			Road now = pq.poll();
			int left = findSet(now.st, p);
			int right = findSet(now.ed, p);
			
			if(left == right) continue;
			
			p[right] = left;
			ans += now.w;
			
			if(++pick == cnt -2) {
				flag = true;
				break;
			}
		}
		if(flag)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	static void exploreIsland(int r, int c, int name) {
		arr[r][c] = name;
		
		for (int i = 0; i < 4; i++) {
			int rr = r + dr[i];
			int rc = c + dc[i];
			
			if(rr >= R || rc >= C || rr < 0 || rc < 0 || arr[rr][rc] != 1) continue;
			
			exploreIsland(rr, rc, name);
		}
	}
	
	static int findSet(int x, int[] p) {
		if(p[x] == x) return x;
		return p[x] = findSet(p[x], p);
	}
	
	static boolean in(int rr, int rc) {
		return rr < R && rr >= 0 && rc < C && rc >= 0;
	}
	
	static class Road implements Comparable<Road>{
		int st;
		int ed;
		int w;
		Road(int st, int ed, int w){
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.w, o.w);
		}
		@Override
		public String toString() {
			return "[ 시작점 : " + st + ", 도착점 : " + ed + ", 길이 : " + w + " ]";
		}
	}
}
