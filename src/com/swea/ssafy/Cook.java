package com.swea.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cook {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			sng = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sng[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			imageCooking(0, 0);
			System.out.printf("#%d %d\n", tc, min);
		}
	}

	static int min;
	static int check = 0;
	static int N;
	static int[][] sng;

	private static void imageCooking(int depth, int sel) {
		if (depth == N / 2) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ((check & 1 << i) != 0 && (check & 1 << j) != 0) {
						a += sng[i][j];
					} else if ((check & 1 << i) == 0 && (check & 1 << j) == 0) {
						b += sng[i][j];
					}
				}
			}

			min = Math.min(min, Math.abs(a - b));
			return;
		}

		if (N/2 - depth < N - sel)
			return;
		
//		check += 1 << depth;
//		imageCooking(depth + 1, sel + 1);
//		check -= 1 << depth;
//		imageCooking(depth + 1, sel);

		for (int i = sel; i < N; i++) {
			check += 1 << depth;
			imageCooking(depth + 1, i + 1);
			check -= 1 << depth;
		}
	}
}
