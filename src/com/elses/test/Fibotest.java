package com.elses.test;

import java.util.Scanner;

public class Fibotest {
	public static void main(String[] args) {
		new Fibotest().solution();
	}
	
	long[] f;

	private void solution() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		f = new long[N + 1];
		
		sc.close();
		
		long ans = fibo(N);
		
		System.out.println(ans);
	}

	private long fibo(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		
		if(f[n] != 0)
			return f[n];
		
		return f[n] = fibo(n-1) + fibo(n-2);
	}
}
