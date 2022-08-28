package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Magnetic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] arr = new int[100][100];
			StringTokenizer s;
			for (int i = 0; i < 100; i++) {
				s = new StringTokenizer( br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(s.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < 100; i++) {
				boolean flag = true; // true : 1 // false : 2
				for (int j = 0; j < 100; j++) {
					int now = arr[j][i];
					if(flag && now == 1) {
						flag = false;
					}else if(!flag && now == 2) {
						flag = true;
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
}
