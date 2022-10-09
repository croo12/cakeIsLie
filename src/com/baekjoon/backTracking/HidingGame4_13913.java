package com.baekjoon.backTracking;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class HidingGame4_13913 {
	static int[] check;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();

		if (N > K) {
			StringBuilder sb = new StringBuilder();
			sb.append(N - K).append('\n');
			for (int i = N; i >= K; i--) {
				sb.append(i).append(' ');
			}
			System.out.println(sb);
		} else {
			min = 100002;
//			dfs(0, N, "");

			boolean[] vis = new boolean[K * 2 + 1];
			Queue<SB> q = new ArrayDeque<>();
			q.offer(new SB(N, "" + N + " ", 0));
			vis[N] = true;
			while (!q.isEmpty()) {
				SB now = q.poll();

				if (now.now == K) {
					min = now.cnt;
					root = now.path;
					break;
				}

//				if(N > K) {
//					StringBuilder sb = new StringBuilder();
//					sb.append(now.path);
//					sb.append(now.now - K).append('\n');
//					for (int i = now.now - 1; i >= K; i--) {
//						sb.append(i).append(' ');
//					}
//					System.out.println(sb);
//				}else {
				for (int i = 0; i < 3; i++) {
					int rnow = now.now;

					switch (i) {
					case 0:
						rnow = rnow + 1;
						break;
					case 1:
						rnow = rnow * 2;
						break;
					case 2:
						rnow = rnow - 1;
						break;
					}

					if (rnow >= K * 2 || rnow < 0 || vis[rnow])
						continue;

					vis[rnow] = true;
					q.offer(new SB(rnow, now.path + rnow + " ", now.cnt + 1));
				}
//				}
			}

			System.out.println(min);
			System.out.println(root);
		}

		sc.close();
	}

	static int min;
	static String root;

//	static void dfs(int cnt, int now, String path) {
//		if (cnt >= min || now >= K * 2 || now < 0)
//			return;
//
//		if (now == K) {
//			min = cnt;
//			root = path;
//			return;
//		}
//
//		if (now > K) {
//			StringBuilder sb = new StringBuilder();
//			for (int i = now; i >= K; i--) {
//				sb.append(i).append(' ');
//			}
//			dfs(cnt + (now - K), K, path + sb.toString());
//
//			return;
//		}
//
//		// 순간이동하기
//		dfs(cnt + 1, now * 2, path + now + " ");
//		// 걍 걷기
//		dfs(cnt + 1, now + 1, path + now + " ");
//		// 뒤로가기
//		dfs(cnt + 1, now - 1, path + now + " ");
//	}

	static class SB {
		int now;
		int cnt;
		String path;

		SB(int now, String path, int cnt) {
			this.now = now;
			this.path = path;
			this.cnt = cnt;
		}
	}
}
