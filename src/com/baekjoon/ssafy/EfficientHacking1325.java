package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EfficientHacking1325 {
	static int N;
	static PC[] pcs;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		pcs = new PC[N + 1];
		for (int i = 1; i <= N; i++) {
			pcs[i] = new PC(i);
		}

		int M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pcs[b].trust[a] = true;
			pcs[b].isLast = false;
		}

		boolean[] vis;
		int max = -1;
		for (int i = 1; i <= N; i++) {
			if(!pcs[i].isLast) {
				cnt = 0;
				vis = new boolean[N+1];
				search(pcs[i], vis);
				pcs[i].num = cnt;
//				pcs[i].trust = vis;
				max = Math.max(cnt, max);
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(i + "번째 PC의 값 : " + pcs[i].num + " "); 
//		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++)
			if(pcs[i].num == max)
				sb.append(i).append(' ');
		
		System.out.println(sb);
	}

	private static void search(PC pc, boolean[] vis) {
//		if(pc.num != 1) {
//			cnt += pc.num;
//			return;
//		}
		cnt++;
		vis[pc.me] = true;
		
		for (int i = 1; i <= N; i++) {
			if(pc.trust[i] && !vis[i])
				search(pcs[i], vis);
		}
//		System.out.println( pc.me + "번 PC의 리턴 값 : " + result);
	}

	static class PC {
		boolean[] trust;
		int num;
		int me;
		boolean isLast;

		PC(int me) {
			trust = new boolean[N + 1];
			num = 1;
			this.me = me;
			isLast = true;
		}
	}
}
