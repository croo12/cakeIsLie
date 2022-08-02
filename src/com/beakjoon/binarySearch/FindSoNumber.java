package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindSoNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		
		int cnt = 0;
		
		int[] ns = Arrays.stream(s).mapToInt(str -> Integer.parseInt(str)).toArray();
		
//		System.out.println(Arrays.toString(ns));
		
		
		for (int i = 0; i < n; i++) {
			int now = ns[i];
			if(now == 1) {
				cnt++;
			}else {
				for (int j = 2; j < now; j++) {
					if(now%j == 0) {
						cnt++;
						break;
					}
				}
			}
		}
		
		System.out.println(n-cnt);
	}
}
