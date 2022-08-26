package com.swea.d3;

import java.util.Scanner;

public class HambergerDiet {
	
	static int N;
	static int L;
	static int[] taste;
	static int[] cal;
	static boolean[] check;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			taste = new int[N];
			cal = new int[N];
			check = new boolean[N];
			L = sc.nextInt();
			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			max = 0;
			
			makeHamburger(0);
			
			System.out.println(max);
		}
		
		sc.close();
	}
	
	private static void makeHamburger(int idx) {
		
		if(idx == N) {
			int limit = 0;
			int now = 0;
			for (int i = 0; i < N; i++) {
				if(check[i]) {
					limit += cal[i];
					now += taste[i];
					if(limit <= L) {
						max = Math.max(now, max);
					}
				}
			}
			
			return;
		}
		
		check[idx] = true;
		makeHamburger(idx+1);
		check[idx] = false;
		makeHamburger(idx+1);
	}
}
