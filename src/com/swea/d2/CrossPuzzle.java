package com.swea.d2;

import java.util.Scanner;

public class CrossPuzzle { // 클래스 이름을 Solution으로 바꿔야 한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case+" ");
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] sq = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sq[i][j] = sc.nextInt();
				}
			}
			
			int[] checker = new int[N+1];
			
			for (int i = 0; i < N; i++) {
				int row = 0;
				int col = 0;
				for (int j = 0; j < N; j++) {
					//row
					if(sq[i][j] == 1) {
						row++;
					}else {
						checker[row] += 1;
						row = 0;
					}
					//col
					if(sq[j][i] == 1) {
						col++;
					}else {
						checker[col] += 1;
						col = 0;
					}
				}
				checker[row] += 1;
				checker[col] += 1;
				row = 0;
				col = 0;
			}
			
			System.out.println(checker[K]);
		}
		sc.close();
	}
}
