package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] num = new int[M][4];
		
		for (int i = 0; i < N; i++) {
			String dna = br.readLine();
			
			for (int j = 0; j < M; j++) {
				char now = dna.charAt(j);
				switch(now) {
				case 'A':
					num[j][0]++;
					break;
				case 'C':
					num[j][1]++;
					break;
				case 'G':
					num[j][2]++;
					break;
				case 'T':
					num[j][3]++;
					break;
				}
			}
		}
		
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < M; i++) {
			int max = 0;
			int idx = -1;
			for (int j = 0; j < 4; j++) {
				if(num[i][j] > max) {
					idx = j;
					max = num[i][j];
				}
			}
			switch(idx) {
			case 0:
				sb.append('A');
				break;
			case 1:
				sb.append('C');
				break;
			case 2:
				sb.append('G');
				break;
			case 3:
				sb.append('T');
				break;
			}
			sum += N - max;
		}
		
		System.out.println(sb);
		System.out.println(sum);
	}
}
