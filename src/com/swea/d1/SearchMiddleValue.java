package com.swea.d1;

import java.util.Scanner;

public class SearchMiddleValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int tmp;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(arr[i] < arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		System.out.println(arr[N/2]);
		sc.close();
	}
}
