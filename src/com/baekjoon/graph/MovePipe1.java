package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MovePipe1 {
	static int cnt = 0;
	static int n;
	static int[][] room;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		room = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selectWay(1, 0, 0);

		System.out.println(cnt);
	}

	private static void selectWay(int x, int y, int status) {
		// 0 가로, 1 대각선 2 세로
		// System.out.printf("x : %d , y : %d , status : %d\n",x,y,status);
		if (x + 1 < n && room[y][x + 1] == 0 && (status == 0 || status == 1))
			selectWay(x + 1, y, 0);
		if (x + 1 < n && y + 1 < n && room[y][x + 1] == 0 && room[y + 1][x + 1] == 0 && room[y + 1][x] == 0)
			selectWay(x + 1, y + 1, 1);
		if (x < n && y + 1 < n && room[y + 1][x] == 0 && (status == 1 || status == 2))
			selectWay(x, y + 1, 2);
		if (x == n - 1 && y == n - 1)
			cnt++;
	}
}
