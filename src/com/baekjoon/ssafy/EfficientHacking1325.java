package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EfficientHacking1325 {
	static int N;
	static int cnt;
	static ArrayList<ArrayList<Integer>> trust = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			trust.add(new ArrayList<>());
		}

		int M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			trust.get(b).add(a);
		}
		
		int[] ans = new int[N+1]; 
		int max = -1;
		for (int i = 1; i <= N; i++) {
			cnt = 0;
			bfs(i);
			ans[i] = cnt;
			max = Math.max(cnt, max);
		}

	StringBuilder sb = new StringBuilder();
	for(int i = 1;i<=N;i++)
		if(ans[i]==max)
			sb.append(i).append(' ');

	System.out.println(sb);
	}
	
	static void bfs(int k) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] vis = new boolean[N+1];
		q.offer(k);
		vis[k] = true;
		
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			cnt++;
			
			for (int i : trust.get(now)) {
				if(!vis[i]) {
					q.offer(i);
					vis[i] = true;
				}
			}
		}
	}
}
