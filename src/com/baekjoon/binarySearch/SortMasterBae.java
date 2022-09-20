package com.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortMasterBae {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		int[] qs = new int[m];
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			qs[i] = Integer.parseInt(br.readLine());
		}
			
		Arrays.sort(a);
			
		for(int i = 0; i < m; i++) {
			int ans = qs[i];
				
			int start = 0;
			int end = n-1;
			int mid = (start+end)/2;
				
			while(end >= start) {
				if(a[mid] >= ans) {
					end = mid-1;
				}else if(a[mid] < ans) {
					start = mid+1;
				}
					
				mid = (start+end)/2;
			}

			if(start < n && start >= 0 && a[start] == ans) System.out.println(start);
			else System.out.println(-1);
			
		}
	}
}
