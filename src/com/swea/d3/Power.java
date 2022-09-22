package com.swea.d3;

import java.util.Scanner;

public class Power {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.printf("#%d %d\n",tc,pow(n,m));
			
		}
		
		sc.close();
	}
	
	static int pow(int n, int m) {
		if(m == 1)
			return n;
		
		int half = pow(n, m/2);
		
		if(m%2==0)
			return half * half;
		else
			return half * half * n;
		
	}
}
