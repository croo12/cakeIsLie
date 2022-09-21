package com.baekjoon.graph;

import java.util.Scanner;

public class FourSqaures {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] paper = new boolean[101][101];
		
		int cnt = 0;
		
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			
			for (int j = y; j < endY; j++) {
				for (int j2 = x; j2 < endX; j2++) {
					if(!paper[j][j2]) {
						paper[j][j2] = true;
						cnt++;
					}
				}
			}
		}
		sc.close();
		System.out.println(cnt);
	}
}
