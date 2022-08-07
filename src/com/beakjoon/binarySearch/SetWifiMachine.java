package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SetWifiMachine {
	
	static int[] xs;
	static int m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		xs = new int[n];
		for (int i = 0; i < n; i++) {
			xs[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(xs);	
		long start = 1;
		long end = 1000000000;
		long mid = (end+start)/2;
		while(end >= start) {
//			System.out.println(start + "     " + end + "     " + mid);
			if(check(mid)) {
				start = mid +1;
			}else {
				end = mid-1;
			}
			mid= (start+ end)/2;
		}
		System.out.println(end);
	}
	
	private static boolean check(long mid) {
		int num = m-1;
		int now = xs[0];
		for (int i = 1; i < xs.length; i++) {
			int position = xs[i];
			if((position - now) < mid) {
				continue;
			}else {
				now = position;
				num--;
			}
		}
		if(num <= 0 ) return true;
		else return false;
	}
}
