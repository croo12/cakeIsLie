package com.swea.d3;

import java.util.Scanner;

public class SumOfParts {
	
	static int N;
	static int K;
	static int[] arr;
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			check = new boolean[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			cnt = 0;
			powerSet(0);
			System.out.println("#"+tc+" "+ cnt);
		}
		sc.close();
	}
	static int cnt = 0;
	static void powerSet(int idx) {
		if(idx == arr.length) {
			int sum = 0;
			for(int i = 0; i < arr.length; i++) {
				if( check[i]) {
					sum += arr[i];
				}
			}
			if( K == sum) {
				cnt++;
			}
			return;
		}
		check[idx] = true;
		powerSet(idx+1);
		check[idx] = false;
		powerSet(idx+1);
	}
}
