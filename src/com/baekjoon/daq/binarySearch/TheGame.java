package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long z = y*100/x ;
		
		System.out.println(z);
		
		int start = 0;
		int end = 1000000000;
		int mid = (start+end)/2;
		if(z < 99 && z >= 0) {
			while(end - start >= 0) {
				long now_z = (y+mid)*100/(x+mid) ;
				if(now_z == z+1) {
					break;
				}else if(now_z > z+1) {
					end = mid-1;
				}else {
					start = mid+1;
				}
				mid = (end+start)/2;
			}
			for(int i = 0; i <= mid; i++) {
				if((y-i+mid)*100/(x-i+mid)==z) {
					System.out.println(mid-i+1);
					break;
				}
			}
		}else {
			System.out.println(-1);
		}
	}
}
