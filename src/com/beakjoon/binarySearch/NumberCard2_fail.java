package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberCard2_fail { //시간초과
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		short[] numbers = new short[20000001];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int len = Integer.parseInt(st.nextToken());
			numbers[10000000 + len]++;
		}
		
		int m = Integer.parseInt(br.readLine());
//		int[] ans = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			System.out.print(numbers[10000000 + Integer.parseInt(st2.nextToken())]+" ");
		}
	}
}
