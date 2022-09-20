package com.baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RememberKing {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		for (int tc = 1; tc <= T; tc++) {
			int a = Integer.parseInt(br.readLine());
			int[] aar = new int[a];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a; i++) {
				aar[i] = Integer.parseInt(st.nextToken());
			}
			int b = Integer.parseInt(br.readLine());
			int[] bar = new int[b];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < b; i++) {
				bar[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(aar);
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < bar.length; i++) {
				int ans = bar[i];
				int start = 0;
				int end = a-1;
				int mid = (start + end)/2;
				while(end >= start) {
					if(ans > aar[mid]) {
						start = mid+1;
					}else if(ans < aar[mid]) {
						end = mid - 1;
					}else {
						break;
					}
					mid = (start+end)/2;
				}
				if(ans != aar[mid]) sb.append("0\n");
				else sb.append("1\n");
			}
			System.out.print(sb);
		}
	}
}
