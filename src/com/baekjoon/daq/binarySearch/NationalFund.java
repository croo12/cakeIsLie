package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NationalFund {
//http://colorscripter.com/s/VwbRYnC	
	 static long[] budgets;
	 static long m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		budgets = new long[n];
		for (int i = 0; i < n; i++) {
			budgets[i] = Long.parseLong(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		
		if( m >= Arrays.stream(budgets).sum()) {
			System.out.println(Arrays.stream(budgets).max().getAsLong());
		}else {
			long start = 0;
			long end = 100000;
			long mid = (start + end)/2;
			while(end - start >=0) {
				boolean flag = possible(mid);
				if(flag && !possible(mid+1)) {
					break;
				}else if(flag){
					start = mid + 1;
				}else {
					end = mid - 1;
				}
				mid = (start+end)/2;
			}
			System.out.println(mid);
		}
	}
	
	private static boolean possible(long mid) {
		long sum = 0;
		for(long l : budgets) {
			if(l < mid) {
				sum += l;
			}else {
				sum += mid;
			}
		} 
//		System.out.println("값 : "+mid+"합계 : " + sum);
		if(sum > m) {
			return false;
		}else {
			return true;
		}
	}
}
