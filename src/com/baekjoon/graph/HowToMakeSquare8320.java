package com.baekjoon.graph;

import java.util.Scanner;

public class HowToMakeSquare8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		while (N != 0) {
			int cnt = 0;
			int tmp = 0;
			while(cnt++ <= N) {
				if(N % cnt == 0) {
					tmp++;
				}
			}
			if(tmp%2 ==0)
				sum += tmp/2;
			else 
				sum += tmp/2 + 1;
			N--;
		}
		System.out.println(sum);
		sc.close();
	}
}
