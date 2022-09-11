package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game2048_easy12100_ver2 {

	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] arr;
	
	static int max = 0;
	static int[] dirs = new int[5];
	static int[][] proto;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		int now;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				now = Integer.parseInt(st.nextToken());
				if (now != 0) {
					arr[i][j] = now;
					max = Math.max(now, max);
				}
			}
		}

		backT(0);

		System.out.println(max);
	}

	static void backT(int depth) {
		if (depth == 5) {
			proto = new int[N][];
			for (int i = 0; i < N; i++) {
				proto[i] = arr[i].clone();
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(proto[i][j] + " ");
//				}
//				System.out.println();
//			}

			for (int i = 0; i < 5; i++) {
				move(dirs[i]);
//				for (int[] is : proto) {
//					for (int j : is) {
//						System.out.print(j + " ");
//					}
//					System.out.println();
//				}
			}

//			for (int[] is : proto)
//				for (int i : is)
//					max = Math.max(max, i);

			return;
		}

		for (int i = 0; i < 4; i++) {
			dirs[depth] = i;
			backT(depth + 1);
			dirs[depth] = 0;
		}
	}

	static void move(int dir) {
		int now;
		for (int i = 0; i < N; i++) {
			int before = -1;
			int idx;

			if (dir % 2 == 0)
				idx = N - 1;
			else
				idx = 0;

			for (int j = 0; j < N; j++) {
				switch (dir) {
				case 0:
					now = proto[i][N - 1 - j];
					proto[i][N - 1 - j] = 0;
					break;
				case 1:
					now = proto[i][j];
					proto[i][j] = 0;
					break;
				case 2:
					now = proto[N - 1 - j][i];
					proto[N - 1 - j][i] = 0;
					break;
				case 3:
					now = proto[j][i];
					proto[j][i] = 0;
					break;
				default:
					now = 0;
				}

				if (now == 0)
					continue;

				if (before == now) {
					if (dir > 1)
						proto[idx + dy[dir]][i] = now * 2;
					else
						proto[i][idx + dx[dir]] = now * 2;
					
					max = Math.max(now * 2, max);
					before = -1;
				} else {
					if (dir > 1) {
						proto[idx][i] = now;
						idx = idx - dy[dir];
					} else {
						proto[i][idx] = now;
						idx = idx - dx[dir];
					}
					before = now;
				}

			}
		}
	}
}
