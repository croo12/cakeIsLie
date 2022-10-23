package com.baekjoon.daq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestSquareInHistogram6549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//분할 정복으로 풀 수 있지 않을까?
		//근데 반씩 나눠서 구하면 홀수일 때는 어떻게함
		//짝이 안맞으면 어떻게함!!!
		
		StringTokenizer st;
		int N;
		int[] sqs;
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0)
				break;
			
			sqs = new int[N];
			for (int i = 0; i < N; i++) {
				sqs[i] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
