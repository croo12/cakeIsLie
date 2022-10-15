package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortNumbers3_10989 {
	
	static final int X = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] check = new int[X+1];
		while(N-- > 0)
			check[Integer.parseInt(br.readLine())]++;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= X; i++) {
			while(check[i]-- > 0)
				sb.append(i).append('\n');
		}
		System.out.print(sb);
	}
}
