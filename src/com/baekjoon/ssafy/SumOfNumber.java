package com.baekjoon.ssafy;

import java.util.Scanner;

public class SumOfNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		String n = sc.next();
		String[] s = n.split("");
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			sum += Integer.parseInt(s[i]);
		}
		System.out.println(sum);
		sc.close();
	}
}
