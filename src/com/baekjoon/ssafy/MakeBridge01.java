package com.baekjoon.ssafy;

import java.util.Scanner;

public class MakeBridge01 { // 클래스 이름을 Main으로 바꿔야 한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			// B에서 A번선택
			// 중복불가
			long result = 1;
			
			long f_b = 1;
			for (int j = 0; j < A; j++) {
				f_b *= B-j;
				f_b /= j+1;
			}

			result = f_b;
			
			System.out.println(result);
		}
		sc.close();
	}
}
