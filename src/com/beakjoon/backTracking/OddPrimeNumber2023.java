package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddPrimeNumber2023 {
	static boolean[] notPn;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int MAX = (int)Math.pow(10, N);
		notPn = new boolean[MAX];
		notPn[0] = true; notPn[1] = true;
		
		for (int i = 2; i < MAX; i++)
			if(!notPn[i])
				for (int j = i*i; j < MAX; j+=i)
					notPn[j] = true;
		
		dfs(0,0);
		
		System.out.print(sb);
	}
	
	private static void dfs(int num, int depth) {
		if(depth == N) {
			sb.append(num/10).append('\n');
			return;
		}
		
		for (int i = num; i < num+10; i++) {
			if(!notPn[i])
				dfs(i*10,depth+1);
		}
		
	}
}
