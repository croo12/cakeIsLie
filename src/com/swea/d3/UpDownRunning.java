package com.swea.d3;

import java.util.Scanner;

public class UpDownRunning {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			int last = sc.nextInt();
			int max = 0;
			int min = 0;
			for (int i = 1; i < N; i++) {
				int now = sc.nextInt();
				int diff = now - last;
				
				max = Math.max(diff, max);
				min = Math.min(diff, min);
				
				last = now;
			}
			
			System.out.printf("#%d %d %d\n",test_case, max, min*-1);
		}
		sc.close();
	}
}
