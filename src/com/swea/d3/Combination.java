package com.swea.d3;

import java.util.Scanner;

public class Combination {
	
	static final int NUM = 1234567891;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			//==============================
//			int[] input = randomInputMachine();
			//==============================
			
//			long n = input[0];
//			long r = input[1];
			long n = sc.nextInt();
			long r = sc.nextInt();
//			System.out.println(n + " " + r);
			//n * (n-1) * ... * (r+1) /
			// (n! * (r! * ( n - r )! )^ p-2) % p
			
			long ans = (fact(n) * pow(( (fact(n-r) * fact(r)) % NUM) , NUM-2 )) % NUM;
			
			System.out.printf("#%d %d\n",tc,ans);
		}
		
		sc.close();
	}
	
	static long pow (long n, long k) {
		if(k== 1) return n;
		
		long half = pow(n,k/2);
		
		if(k%2 == 0)
			return (half * half) % NUM;
		else
			return (((half * half) % NUM) * n) % NUM;
		
	}
	
	static long fact(long n) {
		if(n == 0) return 1;
		if(n == 1) return 1;
		
		long now = 1;
		for (int i = 1; i <= n; i++) {
			now *= i;
			now = now % NUM;
		}
		
		return now%NUM;
	}
	
	static int[] randomInputMachine() {
		int[] inputs = new int[2];
		
		inputs[0] = (int)(1000000 * Math.random());
		inputs[1] = (int)(inputs[0] * Math.random());
		
		return inputs;
	}
	
}
