package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StrangePub {
	
	static long[] mak;
	static long m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		mak = new long[n];
		for (int i = 0; i < n; i++) {
			mak[i] = Long.parseLong(br.readLine());
		}
		
		long start = 1;
		long end = 2147483648L * 10000;  
		long mid = (start+end)/2;
		while(end >= start) {
			if(check(mid)) {
				start = mid+1;
			}else {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		System.out.println(end);
	}
	
	private static boolean check(long mid) {
		
		long sum = 0;
		
		for (int i = 0; i < mak.length; i++) {
			sum += mak[i]/mid;
		}
		
		if(sum >= m) return true;
		else return false;
	}
}
