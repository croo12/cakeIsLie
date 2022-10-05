package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoDown2096 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] min = new int[2][3];
		int[][] max = new int[2][3];
		min[0] = new int[3];
		max[0] = new int[3];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			min[1][0] = left + Math.min(min[0][0], min[0][1]);
			max[1][0] = left + Math.max(max[0][0], max[0][1]);
			
			min[1][1] = mid + Math.min(min[0][0], Math.min(min[0][1], min[0][2]));
			max[1][1] = mid + Math.max(max[0][0], Math.max(max[0][1], max[0][2]));
			
			min[1][2] = right + Math.min(min[0][1], min[0][2]);
			max[1][2] = right + Math.max(max[0][1], max[0][2]);
			
			min[0] = min[1];
			max[0] = max[1];
			
			min[1] = new int[3];
			max[1] = new int[3];
		}
		
		System.out.println(Math.max(max[0][0], Math.max(max[0][1], max[0][2])) + " " + Math.min(min[0][0], Math.min(min[0][1], min[0][2])));
	}
}
