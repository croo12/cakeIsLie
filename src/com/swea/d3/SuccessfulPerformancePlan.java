package com.swea.d3;

import java.util.Scanner;

public class SuccessfulPerformancePlan {
	static char[] pp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			pp = sc.next().toCharArray();
			int start = 0;
			int end = 1001;
			int mid;
			while(end >= start) {
				mid = (start + end)/2;
				if(check(mid))
					end = mid - 1;
				else
					start = mid + 1;
			}
			System.out.printf("#%d %d\n",tc,start);
		}
		sc.close();
	}
	
	private static boolean check(int n) {
		int sum = n;
		int cnt = 0;
		while(cnt < pp.length-1) {
			sum+= pp[cnt++]-'0';
			if(sum < cnt)
				return false;
		}
		return true;
	}
}
