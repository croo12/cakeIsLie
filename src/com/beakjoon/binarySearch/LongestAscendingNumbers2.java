package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestAscendingNumbers2 {
	
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
		longestAscend(0);
		int result = Arrays.stream(sums).max().getAsInt();
		
		System.out.println(result);
	}
	
	private static void longestAscend(int idx) {
		int max = 0;
		for (int i = idx+1; i < T; i++) {
			if(snake[i] > snake[idx]) {
				if(sums[i] > max) {
					max = sums[i];
				}else if(sums[i] == 0) {
					longestAscend(i);
					if(sums[i] > max)
						max = sums[i];
				}
			}
		}
		sums[idx] = max+1;
	}
}
