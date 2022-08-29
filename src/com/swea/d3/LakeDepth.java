package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LakeDepth {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {0,0,1,1,1,-1,-1,-1};
		int[] dy = {1,-1,0,1,-1,0,1,-1};
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			char[][] lake = new char[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					lake[i][j] = st.nextToken().charAt(0);
				}
			}
			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 0;
					for (int k = 0; k < 8; k++) {
						int nX = j + dx[k];
						int nY = i + dy[k];
						if(nY < 0 || nX < 0 || nY >= n || nX >= n) continue;
						if(lake[nY][nX] == 'W') {
							cnt++;
						}
					}
					if(cnt == 0) cnt = 1;
					if(cnt > max) {
						max = cnt;
					}
				}
			}
			System.out.printf("#%d %d\n",tc,max);
		}
	}
}
