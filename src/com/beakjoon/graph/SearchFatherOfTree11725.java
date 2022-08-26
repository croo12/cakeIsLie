package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SearchFatherOfTree11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] root = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
		int[] father = new int[n+1];
		
		int x;
		int y;
		StringTokenizer st;
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(root[x] == null)
				root[x] = new ArrayList<>();
			root[x].add(y);
			if(root[y] == null)
				root[y] = new ArrayList<>();
			root[y].add(x);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		father[1] = -1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < root[now].size(); i++) {
				int tmp = root[now].get(i);
				if(!visited[tmp]) {
					q.add(tmp);
					visited[tmp] = true;
					father[tmp] = now;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(father[i]).append("\n");
		}
		System.out.print(sb);
	}
}
