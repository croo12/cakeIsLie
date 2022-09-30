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
			check = new int[K * 2];
			min = 100002;
			dfs(0, N, "");
			
			boolean[] vis = new boolean[K*2];
			Queue<SB> q = new ArrayDeque<>();
			q.offer(new SB(N, "", 0));
			vis[N] = true;
			while(q.isEmpty()) {
				SB now = q.poll();
				
				if (now.cnt >= min || now.now >= K * 2 || now.now < 0)
					continue;
				
				if (now.now == K) {
					min = now.cnt;
					root = now.path;
					continue;
				}
				
				
				
				
			}
			
			System.out.println(min);
			System.out.println(root);
		}

		sc.close();
	}

	static int min;
	static String root;

	static void dfs(int cnt, int now, String path) {
		if (cnt >= min || now >= K * 2 || now < 0)
			return;

		if (now == K) {
			min = cnt;
			root = path;
			return;
		}

		if (now > K) {
			StringBuilder sb = new StringBuilder();
			for (int i = now; i >= K; i--) {
				sb.append(i).append(' ');
			}
			dfs(cnt + (now - K), K, path + sb.toString());

			return;
		}

		// 순간이동하기
		dfs(cnt + 1, now * 2, path + now + " ");
		// 걍 걷기
		dfs(cnt + 1, now + 1, path + now + " ");
		// 뒤로가기
		dfs(cnt + 1, now - 1, path + now + " ");
	}
	
	static class SB{
		int now;
		int cnt;
		String path;
		SB(int now, String path, int cnt){
			this.now = now;
			this.path = path;
			this.cnt = cnt;
		}
	}
}
