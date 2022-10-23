package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DongHo_KingOfStock1231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] price = new int[N][D];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < D; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		while (day != D - 1) {

			int[][] cache = new int[2][M + 1];

			int income = price[0][day + 1] - price[0][day];
			if (income > 0)
				for (int i = 0; i <= M; i++) {
					cache[0][i] = i / price[0][day] * income;
				}
			
			for (int i = 1; i < N; i++) {
				income = price[i][day + 1] - price[i][day];
				if (income > 0)
					for (int j = 1; j <= M; j++) {
						cache[1][j] = cache[0][j];
	
							for (int k = 1; k <= M; k++) {
								if (j - price[i][day] * k > 0) {
									int val = cache[0][j - price[i][day] * k] + income * k;
									if (cache[1][j] < val) {
										cache[1][j] = val;
									}
								} else
									break;
							}
					}
				else
					cache[1] = cache[0];
				
				cache[0] = cache[1];
				cache[1] = new int[M+1];
			}

			M += cache[0][M];
			day++;
		}

		System.out.println(M);
	}
}
