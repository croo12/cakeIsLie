package com.baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs2579 {
	static int[] arr;
	static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		memo = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(dp(n-1 , 1));
	}
	
	private static int dp(int idx, int walk) {
		if(idx == 0) return arr[0];
		if(idx == 1 && walk == 1) return arr[0] + arr[1];
		if(idx == 1 && walk == 2) return arr[1];
		
		int jump = memo[idx-2][0] == 0 ? memo[idx-2][0] = dp(idx - 2, 1) : memo[idx-2][0];
		if(walk == 2)
				return memo[idx][1] == 0 ? memo[idx][1] = arr[idx] + jump : memo[idx][1];
		else {
			int wakk = memo[idx-1][1] == 0 ? memo[idx-1][1] = dp(idx-1, 2) : memo[idx-1][1];
			return  jump > wakk ? arr[idx] + jump : arr[idx] + wakk; //walk == 1;
		}
	}
}
