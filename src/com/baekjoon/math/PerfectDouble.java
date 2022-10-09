package com.baekjoon.math;

import java.util.Scanner;

public class PerfectDouble {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		int st = (int)Math.sqrt(start);
		int ed = (int)Math.sqrt(end);
		
		int cnt = 0;
		int sum = 0;
		int min = 10001;
		
		for (int i = st; i <= ed; i++) {
			int now = i*i;
			if(now >= start && now <= end) {
				cnt++;
				min = Math.min(min, now);
				sum += now;
			}
		}
		if(cnt > 0)
			System.out.printf("%d\n%d\n",sum,min);
		else 
			System.out.println(-1);
		sc.close();
	}
}
