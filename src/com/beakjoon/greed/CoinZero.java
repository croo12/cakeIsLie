package com.beakjoon.greed;

import java.util.Scanner;

public class CoinZero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coins = new int[n];
		
		for (int i = n-1; i >= 0; i--) {
			coins[i] = sc.nextInt();
		}
		
		int result = 0;
		
		for (int i = 0; i < coins.length; i++) {
			result += k/coins[i];
			k = k%coins[i];
		}
		
		System.out.println(result);
		sc.close();
	}
}
