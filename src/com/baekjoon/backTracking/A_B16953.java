package com.baekjoon.backTracking;

import java.util.Scanner;

public class A_B16953 {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int st = sc.nextInt();
		int ed = sc.nextInt();
		
		ans = 34;
		go(st,ed,0);
		
		if(ans == 34)
			ans = -2;
		System.out.println(ans+1);
		
		sc.close();
	}
	
	static void go(int now, int ed, int cnt) {
		if(cnt > ans || now > ed || now < 1)
			return;
		
		if(now == ed) {
			ans = cnt;
			return;
		}
		
		if(now <= (ed+1)/10 )
			go(now*10 + 1, ed, cnt+1);
		
		if(now <= ed/2 + 1)
			go(now*2, ed, cnt+1);
	}
}
