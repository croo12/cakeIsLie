package com.baekjoon.backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class DwarvesNine2309 {
	static int check;
	static int sum;
	static int[] talls;
	static boolean isPrint = false;
	
	static final int DWARVES = 9;
	static final int IMPOSTERS = 2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		talls = new int[DWARVES];
		for (int i = 0; i < DWARVES; i++) {
			talls[i] = sc.nextInt();
			sum += talls[i];
		}
		Arrays.sort(talls);

		check = 0;

		set(0,0);
		sc.close();
	}

	private static void set(int depth, int sel) {
		if (sel == IMPOSTERS) {
			if(sum == 100) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < DWARVES; i++) {
					if ((1 << i & check) == 0) {
						sb.append(talls[i]).append('\n');
					}
				}
				System.out.print(sb);
				isPrint = true;
			}
			return;
		}

		if (DWARVES - depth < IMPOSTERS - sel || sel == 2 || isPrint)
			return;

		check += 1 << depth;
		sum -= talls[depth];
		set(depth + 1, sel + 1);
		
		if(isPrint) return;
		
		check -= 1 << depth;
		sum += talls[depth];
		set(depth + 1, sel);
	}
}
