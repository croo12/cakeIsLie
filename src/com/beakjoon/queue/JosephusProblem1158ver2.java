package com.beakjoon.queue;

import java.util.Scanner;

public class JosephusProblem1158ver2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int lives = n;
		int k = sc.nextInt();
		
		boolean[] deads = new boolean[n];
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int cnt = 0;
		int idx = 0;
		while(lives != 0) {
			if(!deads[idx%n]) {
				cnt++;
				if(cnt==k) {
					deads[idx%n] = true;
					sb.append(idx%n + 1).append(", ");
					lives--;
					cnt = 0;
				}
			}
			idx++;
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb);
		sc.close();
	}
	
}
