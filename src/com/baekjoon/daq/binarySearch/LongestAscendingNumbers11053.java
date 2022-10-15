package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestAscendingNumbers11053 {
	
	static int T;
	static int[] snake;
	static int[] sums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		snake = new int[T];
		sums = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			snake[i] = Integer.parseInt(st.nextToken());
		}
		
		int ending = checker(T-1);
		System.out.println(ending);
	}
	
	private static int checker(int idx) {
		int result = 1;
		
//		System.out.printf("현재 idx = %d\n",idx);
		
		if(idx != T-1) {
			for (int i = idx+1; i < sums.length; i++) {
				if(snake[idx] < snake[i]) {
					result = Math.max(result, 1+sums[i]);
				}
			}
		}
		
		sums[idx] = result;
		
//		System.out.printf("현재 result = %d\n",result);
		
		if(idx == 0)return result; 
		else return Math.max(result, checker(idx-1));
	}
}
