package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortNumbers1_2750 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[2001];
		while(N-- > 0)
			check[Integer.parseInt(br.readLine()) + 1000] = true;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2001; i++) {
			if(check[i])
				sb.append(i - 1000).append('\n');
		}
		System.out.print(sb);
	}
}
