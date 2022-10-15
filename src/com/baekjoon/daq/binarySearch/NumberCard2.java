package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2 { //시간초과
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cards = new int[n];
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		int m = Integer.parseInt(br.readLine());
		int[] ans = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int val = ans[i];
			
			int start = 0;
			int end = n-1;
			int mid;
			while(end >= start) {
				mid = (start+end)/2;
				if(cards[mid] >= val)
					end = mid -1;
				else
					start = mid +1;
			}
			int res1 = start;
			
			start = 0;
			end = n-1;
			while(end >= start) {
				mid = (start+end)/2;
				if(cards[mid] > val)
					end = mid -1;
				else
					start = mid +1;
			}
			int res2 = end;
//			System.out.printf("val : %d ,, res1 : %d ,, res2 : %d\n",val,res1,res2);
			if(res1 >= n) sb.append(0).append(" ");
			else if(cards[res1] != val) sb.append(0).append(" ");
			else sb.append(res2 - res1 +1).append(" ");
		}
		System.out.println(sb);
	}
}
