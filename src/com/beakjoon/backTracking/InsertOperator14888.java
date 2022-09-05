package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertOperator14888 {
	
	static int[] operator = new int[4];
	static int[] arr;
	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;
	static long now = 0;
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		now = arr[0];
		
		dfs(1);
		
		System.out.printf("%d\n%d\n",max,min);
	}
	
	private static void dfs(int idx) {
		if(idx == N) {
			max = Math.max(now, max);
			min = Math.min(now, min);
			return;
		}
		
		long before = now;
		
		if(operator[0] != 0) {
			now += arr[idx];
			operator[0]--;
			
			dfs(idx+1);
			
			now = before;
			operator[0]++;
		}
		if(operator[1] != 0) {
			now -= arr[idx];
			operator[1]--;
			
			dfs(idx+1);
			
			now = before;
			operator[1]++;
		}
		if(operator[2] != 0) {
			now *= arr[idx];
			operator[2]--;
			
			dfs(idx+1);
			
			now = before;
			operator[2]++;
		}
		if(operator[3] != 0) {
			now /= arr[idx];
			operator[3]--;
			
			dfs(idx+1);
			
			now = before;
			operator[3]++;
		}
	}
}
