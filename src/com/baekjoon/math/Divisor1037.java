package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Divisor1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 1;
		int min = 500001;
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			max = Math.max(now, max);
			min = Math.min(now, min);
		}
		
		System.out.println(max*min);
	}
}
