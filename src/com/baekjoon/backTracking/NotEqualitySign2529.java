package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NotEqualitySign2529 {
	
	static int N;
	static char[] sign;
	static int[] numbers;
	static boolean[] vis = new boolean[10];
	
	static long ansx;
	static long ansn;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sign = new char[N];
		numbers = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		ansx = 0;
		ansn = 10000000000L;
		
		comb(0, -1, true);
		
		System.out.println(ansx);
		System.out.println(("" + ansx).length() > ("" + ansn).length() ? "0" + ansn : ansn);
	}
	
	static void comb(int idx, int sel, boolean up) {
		if(idx == N + 1) {
			long result = 0L;
			
			for (int i = 0; i <= N; i++) {
				result = result * 10 + numbers[i];
			}
			
			if(result > ansx)
				ansx = result;
			
			if(result < ansn)
				ansn = result;
			
			return;
		}
		
		//오른쪽이 얘보다 커야하나요
		boolean isUp = true;
		
		if(idx != N)
			isUp = sign[idx] == '<';
		
		//얘는 왼쪽보다 작아야함
		if(!up)
			for (int i = sel - 1; i >= 0; i--) {
				if(!vis[i]) {
					vis[i] = true;
					numbers[idx] = i;
					
					comb(idx + 1, i, isUp);
					
					vis[i] = false;
				}
			}
		//얘는 왼쪽보다 커야함
		else
			for (int i = 9; i >= sel + 1; i--) {
				if(!vis[i]) {
					vis[i] = true;
					numbers[idx] = i;
					
					comb(idx + 1, i, isUp);
					
					vis[i] = false;
				}
			}
	}
}
