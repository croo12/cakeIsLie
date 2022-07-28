package com.beakjoon.greed;

import java.util.Scanner;

public class SumOfNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long cnt = 0;
		if(n!=0) {
			int now = 0;
			while(now++ >= 0) {
				n -= now;
				if(n==0) {
					cnt = now;
					break;
				}else if(n < 0){
					cnt = now-1;
					break;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
