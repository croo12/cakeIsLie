package com.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCard {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] ns = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
		int m = Integer.parseInt(br.readLine());
		int[] ms = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
		
		Arrays.sort(ns);
		
		for(int i=0; i < m; i++) {
			int ans = ms[i];
			
			int start = 0;
			int end = n-1;
			int mid = (start + end)/2;
			
			boolean flag = false;
			
			while(end - start >= 0) {
//				System.out.println(mid);
				if(ns[mid] < ans) {
					start = mid+1;
				}else if(ns[mid] > ans) {
					end = mid-1;
				}else {
					flag = true;
					System.out.print(1+" ");
					break;
				}
				mid = (start+end)/2;
			}
			if(flag) {}
			else {System.out.print(0 + " ");}	
		}
	}
}
