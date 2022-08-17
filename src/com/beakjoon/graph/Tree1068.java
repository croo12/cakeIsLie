package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tree1068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] tree = new boolean[N][N];
		boolean[] visited = new boolean[N]; 
		boolean[] roots = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(now != -1) {
				tree[i][now] = true;
			}else {
				roots[i] = true;
			}
		}
		
		int D = Integer.parseInt(br.readLine());
		visited[D] = true;
		
		Queue<Integer> q = new LinkedList<>();
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			if(roots[i] && !visited[i]) {
				q.add(i);
				visited[i] = true;
				
				while(!q.isEmpty()) {
					int now = q.poll();
					int tmp = 0;
					
					for (int j = 0; j < N; j++) {
						if(tree[j][now] && !visited[j]) {
							q.add(j);
							tmp++;
							visited[j] = true;
						}
					}
					
					if(tmp == 0) cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
