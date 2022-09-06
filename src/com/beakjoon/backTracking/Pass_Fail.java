package com.beakjoon.backTracking;

import java.util.Scanner;

public class Pass_Fail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		circle = new boolean[N];
		cards = new boolean[N+1];
		cards[0] = true;
		flag = false;
		ans = new int[N];
		
		dfs(0,0);
		
		if(flag) {
			for (int i = 0; i < N; i++) {
				sb.append(ans[i]).append(' ');
			}
		}else {
			sb.append(-1);
		}
		System.out.println(sb);
		sc.close();
	}
	
	static int N;
	
	static boolean flag;
	static StringBuilder sb = new StringBuilder();
	static boolean[] circle;
	static boolean[] cards;
	static int[] ans;
	
	private static void dfs(int num, int idx) {
		if(idx == N || flag) {
			flag = true;
			return;
		}
		
		for(int i : ans) 
			System.out.printf("%d -> ",i);
		System.out.println();
		
		for (int i = N; i >= 1; i--) {
			if(!cards[i] && !circle[(num+i)%N]) {
				ans[idx] = i;
				cards[i] = true;
				circle[(num+i)%N] = true;
				
				dfs((num+i)%N ,idx+1);
				if(flag)
					return;
				
				ans[idx] = 0;
				cards[i] = false;
				circle[(num+i)%N] = false;
			}
		}
	}
}
