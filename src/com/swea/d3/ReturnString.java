package com.swea.d3;

import java.util.Scanner;

public class ReturnString {
	static char[][] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			
			arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String s = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					cnt += checker(i,j);
						
				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
		}
		sc.close();
	}
	
	private static int checker(int i, int j) {
		char[] checker = new char[N];
		checker[0] = arr[i][j];
		boolean flag1 = false;
		boolean flag2 = false;
		if(i+N-1 < 8) {
			for (int k = 1; k < N; k++) {
				checker[k] = arr[i+k][j];
			}
			
			for (int k = 0; k < N/2; k++) {
				if(checker[k] != checker[N-k-1]) {
					break;
				}
				if(k == N/2 -1)
					flag1 = true;
			}
		}	
		
		if(j+N-1 < 8) {
			for (int k = 1; k < N; k++) {
				checker[k] = arr[i][j+k];
			}
			
			for (int k = 0; k < N/2; k++) {
				if(checker[k] != checker[N-k-1]) {
					break;
				}
				if(k == N/2 -1)
					flag2 = true;
			}
		}
		if(flag1 && flag2)
			return 2;
		else if(flag1 || flag2)
			return 1;
		else
			return 0;
	}
}
