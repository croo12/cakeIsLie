package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBRoad {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] RGB = new int[2][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		RGB[0] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			RGB[1][0] = r + (RGB[0][1] > RGB[0][2] ? RGB[0][2] : RGB[0][1]);
			RGB[1][1] = g + (RGB[0][0] > RGB[0][2] ? RGB[0][2] : RGB[0][0]);
			RGB[1][2] = b + (RGB[0][1] > RGB[0][0] ? RGB[0][0] : RGB[0][1]);
			
			RGB[0] = RGB[1];
			RGB[1] = new int[3];
		}
		
		System.out.println(Math.min(RGB[0][0], Math.min(RGB[0][1], RGB[0][2])));
		
	}
}
