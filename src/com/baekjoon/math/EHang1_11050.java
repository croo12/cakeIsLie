package com.baekjoon.math;

import java.util.Scanner;

public class EHang1_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		int[] f = new int[11];
		f[0] = 1;
		for (int i = 1; i < 11; i++) {
			f[i] = f[i-1]*i;
		}
		
		System.out.println(f[n]/(f[k]*f[n-k]));
	}
}
