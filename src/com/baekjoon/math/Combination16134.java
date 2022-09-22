package com.baekjoon.math;

import java.util.Scanner;

public class Combination16134 {
	
	static final long X = 1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		
		long[] f = new long[N+1];
		f[0] = 1;
		for (int i = 1; i <= N; i++) {
			f[i] = f[i-1] * i % X;
		}
		
		long ans = (f[N] * pow(f[R] * f[N-R] % X ,X-2)) % X;
		
		System.out.println(ans);
		sc.close();
	}
	
	private static long pow (long n, long r) {
		if(r == 1) return n;
		long half = pow(n, r/2);
		
		if(r % 2 == 0)
			return half * half % X;
		else
			return (half * half % X) * n % X;
	}
}
