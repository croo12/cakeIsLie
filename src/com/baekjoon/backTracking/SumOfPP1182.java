package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfPP1182 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		ans = 0;
		
		comb(N-1, 0);
		
		System.out.println(ans);
	}
	static int cnt;
	static int ans;
	static int N;
	static int S;
	static int[] arr;

	static void comb(int idx, int sum) {
		if(idx == -1) {
			if(cnt > 0 && sum == S)
				ans++;
			
			return;
		}
		
		cnt++;
		comb(idx - 1, sum + arr[idx]);
		cnt--;
		comb(idx - 1, sum);
	}
}
