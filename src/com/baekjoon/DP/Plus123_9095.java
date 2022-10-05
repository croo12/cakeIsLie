package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123_9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] f = new int[11];
		f[0] = 1;
		f[1] = 1;
		f[2] = 2;
		
		for (int i = 3; i < 11; i++) {
			f[i] = f[i-1] + f[i-2] + f[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(f[Integer.parseInt(br.readLine())]).append('\n');
		}
		System.out.print(sb);
	}
}
