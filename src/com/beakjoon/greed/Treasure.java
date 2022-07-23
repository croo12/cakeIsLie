package com.beakjoon.greed;

import java.util.Scanner;

public class Treasure {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] a = new int[N];
		int[] b = new int[N];
		
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
		}
			
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(a[i] > a[j]) {
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
				if(b[i] < b[j]) {
					tmp = b[i];
					b[i] = b[j];
					b[j] = tmp;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += a[i]*b[i];
		}
		System.out.println(sum);
		sc.close();
	}
}
