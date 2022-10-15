package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EatOrDie {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int an = Integer.parseInt(st.nextToken());
			int bn = Integer.parseInt(st.nextToken());
			
			int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
			int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
			Arrays.sort(b);
			
			long sum = 0;
			
			for (int i = 0; i < an; i++) {
				int start = 0;
				int end = bn-1;
				int mid = (0+bn)/2;
				
				while(end >= start) {
					if(b[mid] >= a[i]) {
						end = mid -1;
					}else {
						start = mid + 1;
					}
					mid = (start + end)/2;
				}
				sum += start;
			}
			System.out.println(sum);
		}
	}
}
