package com.swea.d3;

import java.util.Scanner;

public class NewCalc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] p = doAnd(sc.nextInt());
			int[] q = doAnd(sc.nextInt());
			
			System.out.printf("#%d %d\n",tc,doPlus(p[0]+q[0] , p[1]+q[1]));
		}
		sc.close();
	}
	
	private static int doPlus(int x, int y) {
		int level = x+y;
		
		int start = 1;
		for (int i = 1; i < level; i++) {
			start += i;
		}
		start -= (level - 1);
		
//		System.out.printf("start : %d\n",start);
		
		int row = 1;
		int col = level - 1;
		while(row != x || col != y) {
			row++;
			col--;
			start++;
		}
		return start;
	}
	
	private static int[] doAnd(int n){
		int level = 1;
		int i =1;
		int[] pair = new int[2];
		
		while(n >= i) {
			i += level;
			level++;
		}
		i -= level -1;
		
		pair[0] = 1;
		pair[1] = level - 1;
		while(i != n) {
			pair[0]++;
			pair[1]--;
			i++;
		}
		
		return pair;
	}
}
