package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HamDiet_DownTop {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
//			int[] score = new int[N+1];
//			int[] kcals = new int[N+1];
			
			int[][] cache = new int[N+1][L+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int kcal = Integer.parseInt(st.nextToken());
				
				for (int now = 0; now <= L; now++) {
					if(now - kcal >= 0 && cache[i-1][now] < cache[i-1][now-kcal] + score) {
						cache[i][now] = cache[i-1][now-kcal] + score;
					}else {
						cache[i][now] = cache[i-1][now];
					}
				}
			}
			
			sb.append("#" + tc + " " + cache[N][L] + "\n");
		}
		System.out.print(sb);
	}
}
