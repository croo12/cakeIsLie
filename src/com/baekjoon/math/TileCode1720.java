package com.baekjoon.math;

import java.util.Scanner;

public class TileCode1720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//수업시간에 배운바 2n타일은 피보나치 수열이다. 그런데 f(0)이 1인
		
		//그런데 이 문제에는 가로타일과 네모타일이 있고(둘을 사실 동일한 역할을 하지만 다른 취급임)
		//좌우 대칭은 같은 취급임
		
		//만약 상자와 가로가 같다면, 1 + (N + (N-2) + (N-4) + ... + ( 0 || 1) ) / 2 문제임
		
		
		
		int[] f = new int[N+1];
		f[0] = 1;
		f[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			f[i] = f[i-1] + f[i-2]*2;
		}
		
		System.out.println(f[N]);
		
		sc.close();
	}
}
