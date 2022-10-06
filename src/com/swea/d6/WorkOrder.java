package com.swea.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WorkOrder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#"+tc+" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			
			int[] needs = new int[V+1];
			ArrayList<Integer>[] befores = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				befores[i] = new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int before = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				befores[before].add(end);
				needs[end]++;
			}
			
			Queue<Integer> q = new ArrayDeque<Integer>(V);
			for (int i = 1; i <= V; i++) {
				if(needs[i] == 0)
					q.offer(i);
			}
			
			while(!q.isEmpty()) {
				int x = q.poll();
				sb.append(x+" ");
				ArrayList<Integer> now = befores[x];
				int len = now.size();
				
				for (int i = len-1; i >= 0; i--) {
					int tmp = now.get(i);
					needs[tmp]--;
					if(needs[tmp] == 0) {
						q.offer(tmp);
					}
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
