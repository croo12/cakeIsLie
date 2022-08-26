package com.beakjoon.String;

import java.util.Scanner;

public class NumberNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = Integer.toString(sc.nextInt()*sc.nextInt()*sc.nextInt()).toCharArray();
		int[] cnt = new int[10];
		for (int i = 0; i < a.length; i++) {
			cnt[a[i]-'0']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sb.append(cnt[i]).append("\n");
		}
		System.out.print(sb);
		sc.close();
	}
}
