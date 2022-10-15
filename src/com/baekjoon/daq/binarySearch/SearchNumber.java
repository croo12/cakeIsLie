package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SearchNumber {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			System.out.println(
					binarySearch(
							Integer.parseInt(st2.nextToken()), a)
			);
		}
	}
	
	private static int binarySearch(int b, int[] a) { //b가 있니?
		int start = 0;
		int end = a.length-1;
		int mid = end/2;
//		System.out.println(b);
		
		while(end - start >= 0) {
			if(b == a[mid]) {
				return 1;
			}else if(b > a[mid]) {
				start = mid + 1;
			}else {
				end = mid-1;
			}
			mid = (start + end)/2;
		}
		return 0;
	}
}
