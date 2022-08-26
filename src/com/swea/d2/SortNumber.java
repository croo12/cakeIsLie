package com.swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class SortNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(arr[i]).append(" ");
			}
			System.out.println(sb);
		}
		sc.close();
	}
}
