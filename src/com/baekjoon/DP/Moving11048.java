package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Moving11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] sum = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int max = 0;
				
				if(i-1 >= 0)
					max = sum[i-1][j];
				if(j-1 >= 0)
					max = Math.max(sum[i][j-1], max);
				if(i-1 >= 0 && j-1 >= 0)
					max = Math.max(sum[i-1][j-1], max);
				
				sum[i][j] = arr[i][j] + max;
			}
		}
		
		System.out.println(sum[R-1][C-1]);
	}
}
