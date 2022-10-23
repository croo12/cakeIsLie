package com.baekjoon.daq;

import java.util.Scanner;

public class EHang3_11401 {
	final static long NUM = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//NCK mod NUM = N! * ((N-K)! K!)^(INT-2) mod NUM

		long[] f = new long[N+1];
		f[0] = 1;
		for (int i = 1; i <= N; i++) {
			f[i] = (f[i-1]*i) % NUM;
		}
		
		long ans = f[N] * pow((f[N-K] * f[K]) % NUM , NUM-2) % NUM;
		System.out.println(ans);
		sc.close();
	}
	
	static long pow(long num, long time) {
		if(time == 1)
			return num;
		
		long now = pow(num , time/2);
		if(time%2==0)
			return (now * now) % NUM;
		else
			return (now * now ) % NUM * num % NUM;
	}
}
