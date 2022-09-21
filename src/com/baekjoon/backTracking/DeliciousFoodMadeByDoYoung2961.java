package com.baekjoon.backTracking;

import java.util.Scanner;

public class DeliciousFoodMadeByDoYoung2961 {
	
	static int[][] elements;
	static int ans = 1000000001;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		elements = new int[N][2];
		for (int i = 0; i < N; i++) {
			elements[i] = new int[] {sc.nextInt(), sc.nextInt()};
		}
		
		comb(0,0, false);

		System.out.println(ans);
		sc.close();
	}
	
	static void comb(int idx, int check, boolean newSel) {
		if(idx == N) {
			int sour = 1;
			int bitter = 0;
			
			for (int i = 0; i < idx; i++) {
				if((check & 1 << i) != 0) {
					sour *= elements[i][0];
					bitter += elements[i][1];
				}
			}
			
			ans = Math.min(ans, Math.abs(sour-bitter));
			return;
		}
		
		check += 1 << idx;
		comb(idx+1, check, true);
		
		check -= 1 << idx;
		comb(idx+1, check, false);
		
	}
}
