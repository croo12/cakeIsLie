package com.beakjoon.ssafy;

import java.util.Scanner;

public class SuperMario2815 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] point = new int[10];
		int sum = 0;
		int idx = -1;
		for (int i = 0; i < point.length; i++) {
			point[i] = sc.nextInt();
			sum += point[i];
			if(sum >= 100) {
				idx = i;
				break;
			}
		}
		int result;
		
		if(idx == -1) {
			result = sum;
		}else if(Math.abs(100-sum) > Math.abs(100 - (sum - point[idx]))){
			result = sum - point[idx];
		}else {
			result = sum;
		}
		System.out.println(result);
		sc.close();
	}
}
