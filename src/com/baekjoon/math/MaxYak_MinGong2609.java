package com.baekjoon.math;

import java.util.Scanner;

public class MaxYak_MinGong2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int one1 = sc.nextInt();
		int two1 = sc.nextInt();
		
		int one2 = one1;
		int two2 = two1;
		
		int yak = 1;
		for (int i = 2; i <= 10000 && i <= one1 && i <= two1; i++) {
			while(one1%i == 0 && two1%i == 0) {
				yak*=i;
				one1 /= i;
				two1 /= i;
			}
		}
		
		int max = one2*two2;
		for (int i = Math.max(one2, two2); i <= max; i++) {
			if(i%one2 == 0 && i%two2 == 0)
				max = i;
		}
		
		System.out.println(yak);
		System.out.println(max);
		
		sc.close();
	}
}
