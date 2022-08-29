package com.swea.d3;

import java.util.Scanner;

public class BusOfSamsungCity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] stations = new int[5001];
			for (int i = 0; i < N; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				for (int j = start; j <= end; j++) {
					stations[j]++;
				}
			}
			int P = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for (int i = 0; i < P; i++) {
				sb.append(" ").append(stations[sc.nextInt()]);
			}
			System.out.println(sb);
		}
		sc.close();
	}
}
