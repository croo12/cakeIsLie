package com.baekjoon.CNU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] check = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer ch = new StringTokenizer(br.readLine());
		
		int total = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(ch.nextToken().equals("1")) {
				check[i] = true;
				total += arr[i];
			}
		}
		
		int sum1 = 0;
		int minL = Integer.MAX_VALUE;
		
		
		long max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			sum1 += check[i] ? (arr[i] * -1) : arr[i];
			
			max = Math.max((((long)sum1 - minL) > sum1) ? (long)(sum1 - minL) : sum1, max);

			minL = Math.min(minL, sum1);
		}
		
		System.out.println(max + total);
	}
}
	



