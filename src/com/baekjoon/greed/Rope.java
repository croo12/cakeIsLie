package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Rope {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ropes = new int[n];
		for (int i = 0; i < n; i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ropes);
		
		int max = 0;
		for(int i=n-1; i >= 0; i--) {
			int power = ropes[i]*(n-i);
			if( power > max) {
				max = power;
			}
		}
		System.out.println(max);
	}
}