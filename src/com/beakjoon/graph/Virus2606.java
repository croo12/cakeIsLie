package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus2606 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] networks = new boolean[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			networks[k][l] = true;
			networks[l][k] = true;
		}
		
		Queue<Integer> q = new LinkedList<>(); 
		q.add(1);
		int cnt = 0;
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(networks[i][now] && !visited[i]) {
					q.add(i);
					cnt++;
					visited[i] = true;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
