package com.baekjoon.DP;

import java.util.Scanner;

public class Tiling2n11727 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] f = new int[N+1];
		f[0] = 1;
		f[1] = 1;
		
		//피보나치 그리고 페르마의 소정리
		
		for (int i = 2; i <= N; i++) {
			f[i] = (f[i-1] + f[i-2]*2)%10007;
		}
		
		System.out.println(f[N]);
		
		sc.close();
	}
}
