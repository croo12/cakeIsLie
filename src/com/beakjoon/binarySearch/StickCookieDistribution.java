package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StickCookieDistribution {
	static int[] lengths;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		lengths = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			lengths[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1;
		int end = 1000000000;
		int mid;
		while(end >= start) {
			mid = (start + end)/2;
			if(check(mid)) {
				start = mid +1;
			}else {
				end = mid -1;
			}
		}
		System.out.println(end);
	}
	
	private static boolean check(int mid) {
		int number = 0;
		
		for (int i = 0; i < lengths.length; i++) {
			number += lengths[i] / mid;
		}
		
		if(number >= N) return true;
		else return false;
	}
}
