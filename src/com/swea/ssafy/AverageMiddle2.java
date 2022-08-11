package com.swea.ssafy;

import java.util.Scanner;

public class AverageMiddle2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			
			int[] arr = new int[10];
			int max = -1;
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
				max = Math.max(max, arr[i]);
			}
			
			int[] count = new int[max+1];
			int[] novaArr = new int[10];
			
			for(int i : arr) {
				count[i]++;
			}
			
			for (int i = 0; i < count.length-1; i++) {
				count[i+1] += count[i];
			}
			
			for (int i = 9; i >= 0; i--) {
				int tmp = --count[arr[i]] ;
				novaArr[tmp] = arr[i];
			}
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum += novaArr[i];
			}
			double result = sum/8.0;
			System.out.println(Math.round(result));
		}
		sc.close();
	}
}
