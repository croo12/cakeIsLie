package com.baekjoon.ssafy;

import java.util.Scanner;

public class MakeBridge01_1 { // 클래스 이름을 Main으로 바꿔야 한다.
	public static void main(String[] args) {
		//재귀함수 쓰면 시간초과;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			// B에서 A번선택
			// 중복불가
			long result = 1;

			result = comb(B,A);
			
			System.out.println(result);
		}
		sc.close();
	}
	public static long comb(int n, int r) {
		if(n == r || r == 0)
			return 1;
		else
			return comb(n-1,r-1)+ comb(n-1,r);
	}
}
