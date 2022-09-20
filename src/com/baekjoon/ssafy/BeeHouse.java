package com.baekjoon.ssafy;

import java.util.Scanner;

public class BeeHouse {
	public static void main(String[] args) {
		//1 , 6 , 12 , 18 , 24
		//1 , 7 , 19 , 37 , 61
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int idx = 1;
		int cnt = 0;
		while(true) {
			cnt++;
			if(idx >= n) break;
			idx += 6*cnt;
		}
		System.out.println(cnt);
		sc.close();
	}
}
