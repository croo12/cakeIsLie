package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SnailWantGoUpside2869 {
	public static void main(String[] args) {
		try {
			new SnailWantGoUpside2869().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		System.out.println((V - A)/(A-B) + 1 + ((V - A)%(A-B) != 0 ? 1 : 0));
		
		
	};
}
