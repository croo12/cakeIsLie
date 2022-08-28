package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[1001][1001];
		
		int x,y,w,h;
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for (int j = y; j < y+h; j++) {
				for (int k = x; k < x+w; k++) {
					paper[j][k] = i+1;
				}
			}
		}
		int[] cnt = new int[n+1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				cnt[paper[i][j]]++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(cnt[i]).append("\n");
		}
		System.out.print(sb);
	}
}
