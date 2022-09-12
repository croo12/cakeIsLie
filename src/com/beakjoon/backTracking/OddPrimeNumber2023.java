package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddPrimeNumber2023 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
//		int MAX = (int)Math.pow(10, N);
//		int idx = 1;
//		int[] cnt = new int[N];
//		while(idx > 0) {
//			if(idx == N) {
//				int last = cnt[N-1]*10;
//				for (int i = last; i < last + 10; i++) {
//					if(check(i)) {
////						notPn[i] = true;
//						sb.append(i).append('\n');
//						
//					}
//				}
//				idx--;
//			}
//			int before = cnt[idx-1];
//			boolean flag = false;
//			for (int i = before*10; i < (before*10) + 10; i++) {
//				if(check(i)) {
////					System.out.printf("지금 서순 'idx : %d' , 지금 고른 수 ' %d' \n",idx,i);
//					cnt[idx] = i;
//					idx++;
//					flag = true;
//					break;
//				}
//			}
//			if(!flag)
//				idx--;
//		}
		dfs(0,0);
		
		System.out.print(sb);
	}
	
	private static boolean check(int num) {
		if(num == 0 || num == 1)return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	private static void dfs(int num, int depth) {
		if(depth == N) {
			sb.append(num/10).append('\n');
			return;
		}
		
		for (int i = num; i < num+10; i++) {
			if(check(i)) {
				dfs(i*10,depth+1);
			}
		}
		
	}
}
