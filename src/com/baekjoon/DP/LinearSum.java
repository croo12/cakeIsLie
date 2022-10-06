package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinearSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		sums[0] = arr[0];
		
		//왼쪽부터 계속 누적합을 구했을때 가장 낮은 부분부터 출발하기?
		
		for (int i = 1; i < N; i++) {
			sums[i] = arr[i] = Integer.parseInt(st.nextToken());
			sums[i] += sums[i-1];
		}
		
		int minL = 0;
		int max = -1001;
		for (int i = 0; i < N; i++) {
			max = Math.max(sums[i] - minL, max);
			minL = Math.min(minL, sums[i]);
		}
		
		System.out.println(max);
	}
}
