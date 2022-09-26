package com.baekjoon.CNU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int best = 0;
		for (int i = N-1; i >= 0; i--) {
			int now = arr[i];
			
			best = Math.max(best, max - now);
			max = Math.max(max, now);
		}
		
		System.out.println(best);
	}
}
