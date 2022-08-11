package com.beakjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortNumbers2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] origin = new int[T];
		int[] arr = new int[T];
		
		int max = -1;
		for (int i = 0; i < T; i++) {
			origin[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, origin[i]);
		}
		
		int[] cnt = new int[max+1000001];
		for (int i = 0; i < T; i++) {
			cnt[origin[i]+1000000]++;
		}
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		
		for (int i = T-1; i >= 0; i--) {
			arr[--cnt[origin[i]+1000000]] = origin[i];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(arr[i]);
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
}
