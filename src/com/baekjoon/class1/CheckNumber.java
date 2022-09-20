package com.baekjoon.class1;

import java.util.Scanner;

public class CheckNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum= 0;
		
		for (int i = 0; i < 5; i++) {
			int now = sc.nextInt();
			sum += now*now;
		}
		
		System.out.println(sum%10);
		sc.close();
	}
}
