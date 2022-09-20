package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DdackjiGame {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int[] cnt1 = new int[5];
			int[] cnt2 = new int[5];
			
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				cnt1[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				cnt2[Integer.parseInt(st.nextToken())]++;
			}
			
			boolean flag = false;
			
			for (int j = 4; j > 0; j--) {
				if(cnt1[j] > cnt2[j]) {
					sb.append("A").append("\n");
					flag = true;
					break;
				}else if(cnt1[j] == cnt2[j]) {
					
				}else {
					sb.append("B").append("\n");
					flag = true;
					break;
				}
			}
			if(!flag) sb.append("D").append("\n");
		}
		System.out.print(sb);
	}
}
