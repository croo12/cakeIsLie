package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LanCable {
	
	static long[] cLength; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		cLength = new long[K];
		for (int i = 0; i < K; i++) {
			cLength[i] = Integer.parseInt(br.readLine());
		}
		
		long start = 1;
		long end = Arrays.stream(cLength).max().getAsLong()+1;
		long mid = (start + end)/2;
		
		
		while(end- start >= 0 ) {
//			System.out.println(mid);
			if(doIt(mid) >= N) {
				start = mid + 1;
			}else {
				end = mid-1;
			}
			mid = (start+end)/2;
		}
		
		System.out.println(mid);
		
	}
	
	private static long doIt(long n) {
		long sum = 0;
		for (int i = 0; i < cLength.length; i++) {
			sum += (cLength[i] / n);
		}
		return sum;
	}
}
