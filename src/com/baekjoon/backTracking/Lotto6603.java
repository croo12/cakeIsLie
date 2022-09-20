package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lotto6603 {

	static int[] arr;
	static int[] ans;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			if (N == 0) {
				System.out.print(sb);
				return;
			}
			arr = new int[N];
			ans = new int[6];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0,0);
			
			sb.append('\n');
		}
	}

	private static void dfs(int idx, int cnt) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		if(6 - cnt > N - idx) return;
		
		ans[cnt] = arr[idx];
		dfs(idx+1, cnt+1);
		ans[cnt] = 0;
		dfs(idx+1, cnt);
	}
}
