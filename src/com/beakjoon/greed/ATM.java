package com.beakjoon.greed;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = sc.nextInt();
		}
		
		Arrays.sort(t);
		int sum = 0;
		long ssum = 0;
		
		for (int i = 0; i < t.length; i++) {
			sum += t[i];
			ssum += sum;
		}
		System.out.println(ssum);
		sc.close();
	}
}
