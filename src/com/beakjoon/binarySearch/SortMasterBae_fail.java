package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortMasterBae_fail {
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
//					System.out.println(start + " + " + end + " : " + mid);
				int cnt = 0;
					
				if(a[mid] > ans) {
					end = mid-1;
				}else if(a[mid] < ans) {
					start = mid+1;
				}else {
//					System.out.println("답 "+qs[i]+" 는 " + mid + "에서 발견되었다.");
					for(int j = 1; j <= mid; j++) {
						if(a[mid] == a[mid-j]) {
							cnt+=1;
						}else {
							break;
						}
					}
					System.out.println(mid-cnt);
					break;
				}
					
				mid = (start+end)/2;
			}
			if(a[mid] != ans) {
				System.out.println(-1);
			}
		}
	}
}
