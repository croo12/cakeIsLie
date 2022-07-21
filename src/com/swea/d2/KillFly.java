package com.swea.d2;

import java.util.Scanner;

public class KillFly { // 클래스 이름을 Solution으로 바꿔야 한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#"+test_case+" ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] flies = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					flies[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for (int i = 0; i < N; i++) {
				
				for (int j = 0; j < N; j++) {
					int sum = 0;
					for (int m1 = 0; m1 < M; m1++) { // M,M 씩 무빙하기
						for (int m2 = 0; m2 < M; m2++) {
							if(i+m1 >= 0 && i+m1 < N && j+m2 >= 0 && j+m2 < N) {
								sum+= flies[i+m1][j+m2];
							}
						}
					}
					if(max < sum)
						max = sum;
				}
			}
			
			System.out.println(max);
		}
		sc.close();
	}
}
