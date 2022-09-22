package com.swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestRoot_Brute {
	
	static Pair[] dots;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <=T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			dots = new Pair[N+2]; //0은 회사 1은 집
			arr = new int[N];
			check = new boolean[N+2];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N+2; i++) {
				dots[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			perm(0);
			
			System.out.printf("#%d %d\n",tc,min);
		}
	}
	
	static int[] arr;
	static int min;
	static boolean[] check;
	
	static void perm(int depth) {
		if(depth == N) {
			int sum = 0;
			
			sum+= Math.abs(dots[0].r - dots[arr[0]].r) + Math.abs(dots[0].c - dots[arr[0]].c); 
			for (int i = 1; i < N; i++) {
				sum+= Math.abs(dots[arr[i-1]].r - dots[arr[i]].r) + Math.abs(dots[arr[i-1]].c - dots[arr[i]].c);
			}
			sum += Math.abs( dots[arr[N-1]].r - dots[1].r ) + Math.abs( dots[arr[N-1]].c - dots[1].c );
			
			System.out.println(sum);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 2; i <= N+1; i++) {
			if(!check[i]) {
				arr[depth] = i;
				check[i] = true;
				perm(depth + 1);
				check[i] = false;
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
