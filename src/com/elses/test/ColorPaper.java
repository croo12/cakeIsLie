package com.elses.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper {
	
	static boolean[][] origin = new boolean[100][100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt=0;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());
			
			for (int y = nowY; y < nowY+10; y++) {
				for (int x = nowX; x < nowX+10; x++) {
					if(!origin[y][x]) {
						origin[y][x] = true;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
