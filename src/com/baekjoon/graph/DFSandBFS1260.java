package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSandBFS1260 {
	
	static int N;
	static boolean[] visitedDfs;
	static boolean[] visitedBfs;
	static boolean[][] roads;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		roads = new boolean[N+1][N+1];
		visitedDfs = new boolean[N+1];
		visitedBfs = new boolean[N+1];
		
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			roads[j][k] = true;
			roads[k][j] = true;
		}
		
		
		doDfs(start);
		System.out.println();
		
		//bfs 시작
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visitedBfs[start] = true;
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.printf("%d ",now);
			
			for(int i = 1; i <= N; i++) {
				if(roads[i][now] && !visitedBfs[i]) {
					q.add(i);
					visitedBfs[i] = true;
				}
			}
		}
	}
	
	private static void doDfs(int now) {
		visitedDfs[now] = true;
		System.out.printf("%d ",now);
		
		for (int i = 1; i <= N; i++) {
			if(roads[i][now] && !visitedDfs[i]) {
				doDfs(i);
			};
		}
		
	}
}
