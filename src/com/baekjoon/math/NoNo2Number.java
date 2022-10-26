package com.baekjoon.math;

import java.util.Scanner;

public class NoNo2Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long st = sc.nextLong();
		long ed = sc.nextLong();
		sc.close();
		
		boolean[] check = new boolean[(int)(ed - st) + 1];
		
		int cnt = (int)(ed - st + 1);
		
		for (int i = 2; i <= Math.sqrt(ed); i++) {
			int k = 0;
			System.out.println(i);
			while((st + k)%(i*i) != 0)
				k++;
			
			if(st + k <= ed && check[k] != true)
				for (long j = st + k; j <= ed; j += i*i) {
					if(!check[(int)(j - st)]) {
						check[(int)(j - st)] = true;
						cnt--;
					}
				}
		}
		
		System.out.println(cnt);
	}
}
