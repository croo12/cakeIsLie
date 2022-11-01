package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneLine1138 {
	public static void main(String[] args) {
		try {
			new OneLine1138().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int N;
	int[] guys;
	int[] men;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		guys = new int[N+1];
		men = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			guys[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	boolean flag = true;
	StringBuilder sb = new StringBuilder();
	
	public void dfs(int depth) {
		if(flag && depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(men[i]+" ");
			}
			flag = false;
		}
		
		if(depth == N)
			return;
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < depth; j++) {
				if(men[j] > i)
					cnt++;
				
				if(men[j] == i) {
					cnt = -1;
					break;
				}
			}
			
			if( cnt == guys[i]) {
				men[depth] = i;
				dfs(depth + 1);
			}else
				continue;
		}
	}
}
