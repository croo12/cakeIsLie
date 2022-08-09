package com.beakjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		arr = new int[n+1];
		
		doSearch(n,1);
		
		System.out.println(arr[1]);
	}
	
	private static void doSearch(int n, int x) {
		if(n > 0) {
			if(n%3 == 0 && (arr[n/3] > x || arr[n/3] == 0)) {
				arr[n/3] = x;
				doSearch(n/3,x+1);
			}
			if( n%2 == 0 && (arr[n/2] == 0 || arr[n/2] > x)) {
				arr[n/2] = x;
				doSearch(n/2,x+1);
			}
			if(arr[n-1] == 0 || arr[n-1] > x) {
				arr[n-1] = x;
				doSearch(n-1,x+1);
			}
		}
	}
	
	private static int readInt() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		while(true) {
			int now = br.read(); 
			if(now == ' ' || now == '\n' || now == '\r') {
				return sum;
			}else {
				sum = sum*10 + now - '0';
			}
		}
	}
}
