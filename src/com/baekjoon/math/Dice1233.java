package com.baekjoon.math;

import java.util.Scanner;

public class Dice1233 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ns = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		int[] count = new int[ns[0]+ns[1]+ns[2]+1];
		
		for (int i = 1; i <= ns[0]; i++) {
			for (int j = 1; j <= ns[1]; j++) {
				for (int j2 = 1; j2 <= ns[2]; j2++) {
					count[i+j+j2]++;
				}
			}
		}
		int max = 0;
		int idx = 0;	
		for (int i = 1; i < count.length; i++) {
			if(count[i] > max) {
				max = count[i];
				idx = i;
			}
		}
		System.out.println(idx);
		sc.close();
	}
}
