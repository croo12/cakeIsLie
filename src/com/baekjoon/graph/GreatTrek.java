package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GreatTrek {

	static NationalPair[][] roots;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	// 위. 아래. 오른쪽. 왼쪽.

	public static void main(String[] args) throws IOException {
		GreatTrek me = new GreatTrek();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		// 땅 크기, 최소 ~ 최대
		roots = new NationalPair[n + 1][n + 1];
		int[][] nation = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nation[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<NationalPair> q = new LinkedList<>();

		int days = 0;
		boolean flag;
		// 매일매일
		while (true) {

			flag = true;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					roots[i][j] = me.new NationalPair(j, i);
				}
			}

			// 국경 개방
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {

					for (int k = 0; k < 4; k++) {
						if (roots[i][j].isOpen(k))
							continue;

						int nX = j + dx[k];
						int nY = i + dy[k];

						if (nX < 0 || nY < 0 || nX >= n || nY >= n)
							continue;

						int gap = Math.abs(nation[i][j] - nation[nY][nX]);

						if (r >= gap && gap >= l) {
							flag = false;
							switch (k) {
							case 0:
								roots[i][j].up = true;
								roots[nY][nX].down = true;
								break;
							case 1:
								roots[i][j].down = true;
								roots[nY][nX].up = true;
								break;
							case 2:
								roots[i][j].right = true;
								roots[nY][nX].left = true;
								break;
							case 3:
								roots[i][j].left = true;
								roots[nY][nX].right = true;
							}
						}
					}
				}
			} // 국경 개방 끝

//			System.out.println(roots[0][0]);

			if (flag)
				break;

			days++;

			int[][] alliance = new int[n][n];
			int allianceNumber = 0;
			int[] allianceMans = new int[n * n + 1];

			for (int i = 0; i < n; i++) { // 인구 n 빵
				for (int j = 0; j < n; j++) {
					if (!roots[i][j].visited) {
						allianceNumber++;

						roots[i][j].visited = true;
						q.offer(roots[i][j]);
						alliance[i][j] = allianceNumber;

						int sum = 0;
						int cnt = 0;
						while (!q.isEmpty()) {
							NationalPair now = q.poll();
							sum += nation[now.y][now.x];
							cnt++;

							for (int k = 0; k < 4; k++) {

								if (now.isOpen(k) && !roots[now.y + dy[k]][now.x + dx[k]].visited) {

									q.offer(roots[now.y + dy[k]][now.x + dx[k]]);
									roots[now.y + dy[k]][now.x + dx[k]].visited = true;
									alliance[now.y + dy[k]][now.x + dx[k]] = allianceNumber;
								}
							}
						} // 동맹 탐방

						allianceMans[allianceNumber] = sum / cnt;
						// 얼라이언스 allianceNumber 의 인구수

					} // 연맹 하나씩 처리
				}
			}

			for (int i = 0; i < n; i++) { // 인구 배분
				for (int j = 0; j < n; j++) {
					nation[i][j] = allianceMans[alliance[i][j]];
				}
			}
			// 하루 끝

		} // while

		System.out.println(days); // 지나간 날짜
	}

	class NationalPair {
		boolean left;
		boolean right;
		boolean up;
		boolean down;
		boolean visited = false;

		int x;
		int y;

		public NationalPair(int x, int y) {
			this.x = x;
			this.y = y;
			this.down = false;
			this.up = false;
			this.right = false;
			this.left = false;
		}

		public boolean isOpen(int k) {
			switch (k) {
			case 0:
				if (this.up)
					return true;
				break;
			case 1:
				if (this.down)
					return true;
				break;
			case 2:
				if (this.right)
					return true;
				break;
			case 3:
				if (this.left)
					return true;
			}
			return false;
		}

//		@Override
//		public String toString() {
//			StringBuilder sb = new StringBuilder();
//			sb.append(" x 좌표 : ").append(this.x).append(" y 좌표 : ").append(this.y);
//			sb.append(" 북, 남, 동, 서").append(this.up).append(" , ").append(this.down).append(" , ").append(this.right).append(" , ").append(this.left);
//			
//			return sb.toString();
//		}
	}
}
