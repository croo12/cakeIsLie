package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class EscapeSqr16973 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		boolean[][] vis = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				// true 넌 못지나간다 , false 지나간다
			}
		}
		st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		if(H != 1)
			for (int i = 0; i < M; i++) {
				arr[N - H + 1][i] = arr[N - H + 1][i] != 1 ? 2 : 1;
			}

		int W = Integer.parseInt(st.nextToken());
		if(W != 1)
			for (int i = 0; i < N; i++) {
				arr[i][M - W + 1] = arr[i][M - W + 1] != 1 ? 2 : 1;
			}

		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int er = Integer.parseInt(st.nextToken()) - 1;
		int ec = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					for (int i2 = (i - H + 1 < 0) ? 0 : i - H + 1; i2 <= i; i2++) {
						for (int j2 = (j - W + 1 < 0) ? 0 : j - W + 1; j2 <= j; j2++) {
							arr[i2][j2] = 2;
						}
					}
				}
			}
		}

//		for (int[] as : arr) {
//			for(int i : as) System.out.print(i+" ");
//			System.out.println();
//		}
//		System.out.println();

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(sr, sc, 0));
		vis[sr][sc] = true;

		while (!q.isEmpty()) {
			Pair now = q.poll();

			if (now.r == er && now.c == ec) {
				System.out.println(now.num);
				return;
			}

			for (int k = 0; k < 4; k++) {
				int rr = now.r + dr[k];
				int rc = now.c + dc[k];

				if (rr >= N || rc >= M || rr < 0 || rc < 0)
					continue;
				if (!vis[rr][rc] && arr[rr][rc] == 0) {
					vis[rr][rc] = true;
					q.offer(new Pair(rr, rc, now.num + 1));
				}
			}
		}
		System.out.println(-1);
	}

	static class Pair {
		int r, c, num;

		Pair(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

}
