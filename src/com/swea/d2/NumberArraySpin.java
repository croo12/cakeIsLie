package com.swea.d2;

import java.util.Scanner;

public class NumberArraySpin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int[][] arr90 = new int[N][N];
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr90[i][j] = arr[N-j-1][i];
					
					arr180[i][j] = arr[N-i-1][N-j-1];
					
					arr270[i][j] = arr[j][i];
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr90[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(arr180[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(arr270[N-i-1][j]);
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
		}
		sc.close();
	}
}
