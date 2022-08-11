package com.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhereIsFitForWord {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] puzzle = new int[N+2][N+2];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N+1; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			StringBuilder pattern = new StringBuilder();
			pattern.append(0);
			for (int i = 0; i < K; i++) {
				pattern.append(1);
			}
			pattern.append(0);
			String key = pattern.toString();
			
//			System.out.println("키값은 : " + key);
			
			int cnt = 0;
			
			for (int i = 0; i < N+2; i++) {
				
				String nowRow = "";
				String nowCol = "";
				
				for (int j = 0; j < N+2; j++) {
					nowRow += puzzle[i][j];
					nowCol += puzzle[j][i];
				}
				
//				System.out.println("가로 "+ i +"번 줄"+nowRow);
				
				int idx = 0;
				
				while(true) {
					idx = nowRow.indexOf(key, idx);
					if(idx != -1) {
						cnt++;
						idx++;
					}else {
						break;
					}
				}
				
//				System.out.println("세로 "+ i +"번 줄"+nowCol);
				
				idx = 0;
				
				while(true) {
					idx = nowCol.indexOf(key, idx);
					if(idx != -1) {
						cnt++;
						idx++;
					}else {
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,cnt);
			
		}
	}
}
