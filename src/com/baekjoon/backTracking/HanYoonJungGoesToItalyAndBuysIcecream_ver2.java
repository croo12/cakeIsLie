package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HanYoonJungGoesToItalyAndBuysIcecream_ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		boolean[][] nope = new boolean[N+1][N+1];
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			
			nope[i1][i2] = true;
			nope[i2][i1] = true;
		}
		
		int cnt = 0;
		
		for (int i = 1; i <= N-2; i++) {
			for (int j = i+1; j <= N-1; j++) {
				if(!nope[i][j])
					for (int k = j + 1; k <= N; k++) {
						if (nope[i][k] || nope[j][k])
							continue;
						cnt++;
					}
			}
		}
		
		System.out.println(cnt);
	}
}
