package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MonkeyWantBeHorse1600 {
	//틀린이유
	//1. 메모리 초과 큐가 개많이 들어가나봐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R][C];
		int[][] check = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = {1,-1,0,0};
		int[] dc = {0,0,1,-1};
		
		int[] sdr = {2,2,1,1,-1,-1,-2,-2};
		int[] sdc = {1,-1,2,-2,2,-2,1,-1};
		
		Queue<Monkey> q = new LinkedList<Monkey>();
		q.offer(new Monkey(0,0,0,K));
		
		while(!q.isEmpty()) {
			Monkey now = q.poll();
			
			if(now.r == R-1 && now.c == C-1) {
				System.out.println(now.num);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int rr = now.r + dr[i];
				int rc = now.c + dc[i];
				
				if(rr >= R || rc >= C || rr < 0 || rc < 0) continue;
				if(arr[rr][rc] == 0 && (check[rr][rc] & 1 << now.k) == 0) {
					check[rr][rc] += 1 << now.k;
					q.offer(new Monkey(rr,rc,now.num+1,now.k));
				}
			}
			
			if(now.k > 0)
				for (int i = 0; i < 8; i++) {
					int rr = now.r + sdr[i];
					int rc = now.c + sdc[i];
					
					if(rr >= R || rc >= C || rr < 0 || rc < 0) continue;
					if(arr[rr][rc] == 0 && (check[rr][rc] & 1 << (now.k-1)) == 0) {
						check[rr][rc] += 1 << (now.k-1);
						q.offer(new Monkey(rr,rc,now.num+1,now.k-1));
					}
				}
		}
		
		System.out.println(-1);
	}
	
	static class Monkey{
		int r,c,num,k;
		
		Monkey(int r,int c,int num,int k){
			this.r = r;
			this.c = c;
			this.num = num;
			this.k = k;
		}
	}
}
