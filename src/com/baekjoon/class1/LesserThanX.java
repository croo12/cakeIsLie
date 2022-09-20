package com.baekjoon.class1;

import java.util.Scanner;

public class LesserThanX {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		int now;
		for (int i = 0; i < n; i++) {
			now = sc.nextInt();
			if(now < x) {
				sb.append(now);
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
		sc.close();
	}
}
