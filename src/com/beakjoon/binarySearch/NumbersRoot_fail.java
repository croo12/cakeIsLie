package com.beakjoon.binarySearch;

import java.util.Scanner;

public class NumbersRoot_fail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int start = 1;
		int end = n;
		int mid = (start + end)/2;
		
		System.out.println(mid);
		sc.close();
	}
}
