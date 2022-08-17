package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfConnectedComponent11724 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] comps = new boolean[N+1];
		boolean[][] conn = new boolean[N+1][N+1];
		
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			conn[j][k] = true;
			conn[k][j] = true;
		}
		
		Queue<Integer> q = new LinkedList<>();
		int cnt=0;
		
		for (int i = 1; i <= N; i++) {
			if(!comps[i]) {
				cnt++;
				q.add(i);
				comps[i] = true;
				
				while(!q.isEmpty()) {
					int now = q.poll();
					
					for (int j = 1; j <= N; j++) {
						if(conn[j][now] && !comps[j]) {
							comps[j] = true;
							q.add(j);
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
