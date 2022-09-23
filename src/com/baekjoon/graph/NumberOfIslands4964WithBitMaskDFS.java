package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfIslands4964WithBitMaskDFS {
	static int[] dr = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dc = { 1, -1, 0, 1, -1, 0, 1, -1 };
	
	static long[] map;
	static long zero;
	
	static int width;
	static int height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());

			if (width == 0 && height == 0)
				break;
			
			map = new long[height]; // 1 << (width - 1)
			
			for (int i = 0; i < height; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < width; j++) {
					map[i] = map[i] * 2 + Integer.parseInt(s[j]);
				}
			}
			
			zero = 1L << (width - 1);

			int cnt = 0;

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if((map[i] & (zero >> j)) != 0) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int r, int c) {
		map[r] -= zero >> c;
		
		for (int k = 0; k < 8; k++) {
			int nowR = r + dr[k];
			int nowC = c + dc[k];
			
			if(nowR >= height || nowR < 0 || nowC >= width || nowC < 0) 
				continue;
			if((map[nowR] & (zero >> nowC)) == 0)
				continue;
			
			dfs(nowR,nowC);
		}
	}
}
