package com.swea.d3;

import java.util.Scanner;

public class ProblemNaming {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] cnt = new int[27];
			for (int i = 0; i < N; i++) {
				cnt[sc.next().charAt(0)-'A']++;
			}
			int last = -1;
			for (int i = 0; i < 27; i++) {
				if(cnt[i] < 1) {
					last = i;
					break;
				}	
			}
			System.out.printf("#%d %d\n",tc,last);
		}
		sc.close();
	}	
}
