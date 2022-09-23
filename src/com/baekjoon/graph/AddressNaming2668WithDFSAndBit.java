package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressNaming2668WithDFSAndBit {
	
	static int n;
	static int[] map;
	
	static int left;
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i] = map[i]*2 + s.charAt(j) - '0' ;
			}
		}
		
		left = 1 << (n-1);
		int[] ans = new int[n*n + 1];
		int total = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((map[i] & left >> j) != 0) {
					cnt = 0;
					total++;
					dfs(i,j);
					ans[cnt]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(total).append('\n');
		for (int i = 1; i <= n*n; i++) {
			if(ans[i] > 0) {
				for (int j = 0; j < ans[i]; j++) {
					sb.append(i).append('\n');
				}
			}
		}
		System.out.print(sb);
	}
	
	static int cnt;
	
	static void dfs(int r, int c) {
		map[r] -= left >> c;
		cnt++;
		for (int k = 0; k < 4; k++) {
			int newR = r + dr[k];
			int newC = c + dc[k];
			
			int check = left >> newC;
			if(newR >= n || newC >= n || newR < 0 || newC < 0) continue;
			if((map[newR] & check) == 0) continue;
			
			dfs(newR, newC);
		}
	}
}
