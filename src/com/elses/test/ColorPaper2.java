package com.elses.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColorPaper2 {
	
	static boolean[][] origin = new boolean[102][102];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int nowX = Integer.parseInt(st.nextToken())+1;
			int nowY = Integer.parseInt(st.nextToken())+1;
			
			for (int y = nowY; y < nowY+10; y++) {
				for (int x = nowX; x < nowX+10; x++) {
					origin[y][x] = true;
				}
			}
		}
		
		int[] rx = {1,-1,0,0};
		int[] ry = {0,0,1,-1};
		
		int cnt = 0;
		
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if(origin[i][j]) {
					for(int k=0; k<4; k++) {
						if(!origin[i+ry[k]][j+rx[k]]) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
