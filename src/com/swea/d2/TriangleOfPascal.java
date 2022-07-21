package com.swea.d2;

import java.util.Scanner;

public class TriangleOfPascal { //swea의 기본 양식. 이걸 베껴서 쓰세요.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			System.out.println("#"+test_case);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(make_triangle(i, j)+" ");
				}
				System.out.println();
			}
		
		}
		sc.close();
	}
	
	public static int make_triangle(int N, int i) {
		if(N == 0 || N == 1 || i == 1 || i == N) {
			return 1;
		}else {
			return make_triangle(N-1,i-1)+make_triangle(N-1,i);
		}
	}
}
