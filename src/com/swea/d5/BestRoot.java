package com.swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestRoot {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			Pair[] dots = new Pair[N+2]; //0은 회사 1은 집
			for (int i = 0; i < N+2; i++) {
				dots[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			int best = Math.abs(dots[0].r - dots[1].r) + Math.abs(dots[0].c - dots[1].c); //회사로 부터의 거리
			
			int[] ans = new int[N];
			int idx = 0;
			
			while(idx < N) {
				
				int min = Integer.MAX_VALUE;
				int max = 0;
				
				for (int i = 1; i < N+1; i++) {
				}
				
				
			}
		}
	}
	
	
	static class Pair {
		int r,c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
