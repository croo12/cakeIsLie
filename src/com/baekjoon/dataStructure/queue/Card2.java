package com.baekjoon.dataStructure.queue;

import java.util.Scanner;

public class Card2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 0;
		int idx = 2;
		for (int i = 2; i <= n; i++) {
			if(i == idx) {
				cnt= 0;
				idx*=2;
			}else {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
