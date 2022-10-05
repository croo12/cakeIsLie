package com.swea.d3;

import java.util.Scanner;

public class Zero_OneKnapSack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] weights = new int[N + 1];
			int[] values = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				weights[i] = sc.nextInt();
				values[i] = sc.nextInt();
			}
			
			int[][] ans = new int[N+1][K+1];

			for (int i = 1; i <= N; i++) {
				int weight = weights[i];
				int value = values[i];
				
				for (int w = 0; w <= K; w++) {
					if(w - weight >= 0 && ans[i-1][w] < ans[i-1][w-weight] + value) {
						ans[i][w] = ans[i-1][w-weight] + value;
					}else {
						ans[i][w] = ans[i-1][w];
					}
				}
				
//				System.out.println(i+"번 결과 : "+Arrays.toString(ans[i]));
			}
			
			sb.append("#" + tc + " ").append(ans[N][K]).append('\n');
		}
		
		System.out.print(sb);
		sc.close();
	}
}
