package com.swea.d3;

import java.util.Scanner;

public class Harvest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
//			int[][] arr = new int[n][n];
			
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				char[] cs = sc.next().toCharArray();
				for (int j = 0; j < n; j++) {
					if( Math.abs(i-n/2) + Math.abs(j-n/2) <= n/2)
						sum += cs[j] - '0';
				}
			}
			
			System.out.println(sum);
			
		}
		sc.close();
	}
}
