package com.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HoSProgamer {
	static int[] arr;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long start = 1;
		long end = 2000000000;
		long mid;
		while(end >= start) {
			mid = (start + end)/2;
//			System.out.println("start : " + start + " end : " + end + " mid : " + mid);
			if(check(mid)) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		System.out.println(end);
	}
	
	private static boolean check(long mid) {
		int k = K;
		for (int i = 0; i < arr.length; i++) {
			if(k < 0) break;
			if(arr[i] < mid) {
				k -= mid - arr[i];
			}
		}
		
		if(k < 0) return false;
		else return true;
	}
}
