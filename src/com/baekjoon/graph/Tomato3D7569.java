package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato3D7569 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()),
				h = Integer.parseInt(st.nextToken());

		int[][][] arr = new int[h][r][c];

		Queue<Pair> q = new LinkedList<>();
		int rawTomatos = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < c; k++) {
					int x = Integer.parseInt(st.nextToken());
					if (x != 0) {
						arr[i][j][k] = x;
						if (x == 1)
							q.add(new Pair(i, j, k));
						continue;
					}
					rawTomatos++;
				}
			}
		}

		int[] dh = { 1, -1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, 1, -1, 0, 0 };
		int[] dc = { 0, 0, 0, 0, 1, -1 };

		Pair now;
		int max = 1;
		while (!q.isEmpty()) {
			int t = q.size();
			max++;

			while (t-- > 0) {
				now = q.poll();

				for (int k = 0; k < 6; k++) {
					int rh = now.h + dh[k];
					int rr = now.r + dr[k];
					int rc = now.c + dc[k];

					if (rh < 0 || rr < 0 || rc < 0 || rh >= h || rr >= r || rc >= c || arr[rh][rr][rc] != 0)
						continue;
					
					arr[rh][rr][rc] = 1;
					q.offer(new Pair(rh, rr, rc));
					rawTomatos--;
				}
			}
		}
		if (rawTomatos == 0)
			System.out.println(max - 2);
		else
			System.out.println(-1);
	}

	static class Pair {
		int h, r, c;

		Pair(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}
}
