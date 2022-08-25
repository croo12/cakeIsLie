package com.swea.d3;

import java.util.Scanner;

public class BiggestMoney_ver_2 {
	static char[] pannels;
	static int limit;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			pannels = sc.next().toCharArray();
			limit = sc.nextInt();
			max = 0;
			
			exchange(0,0);
			
			System.out.printf("#%d %d\n",i,max);
		}
		sc.close();
	}
	
	private static void exchange(int n,int idx) {
		
//		System.out.println(n);
		
		if( n == limit) {
			int sum = 0;
			for (int i = 0; i < pannels.length; i++) {
				sum = sum*10 + pannels[i] - '0';
			}
			max = Math.max(sum, max);
			return;
		}
		
		int length = pannels.length;
		char tmp;
		
		for (int i = idx; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				tmp = pannels[i];
				pannels[i] = pannels[j];
				pannels[j] = tmp;
				
				exchange(n+1, i);
				
				pannels[j] = pannels[i];
				pannels[i] = tmp;
			}
		}
	}
}
