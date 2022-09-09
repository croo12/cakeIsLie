package com.beakjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FastestPath1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		int[] length = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			length[i] = Integer.MAX_VALUE;
		}
		length[start] = 0;
		
		HashMap<Integer, ArrayList<Node>> roads = new HashMap<>();
		boolean[] visited = new boolean[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			ArrayList<Node> now = roads.get(u);
			if(now == null)
				now = new ArrayList<>();
			now.add(new Node(v,w));
			roads.put(u, now);
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(length[now.end] < now.weight)
				continue;
			
			ArrayList<Node> list = roads.get(now.end);
			
			if(list == null) {
				visited[now.end] = false;
				continue;
			}
			
			for (Node node : list) {
				int nowLength = length[now.end] + node.weight;
				if(!visited[node.end] && nowLength < length[node.end]) {
					length[node.end] = nowLength;
					q.add(new Node(node.end, nowLength));
				}
			}
			
			visited[now.end] = false;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V+1; i++) {
			if(length[i] != Integer.MAX_VALUE)
				sb.append(length[i]).append('\n');
			else {
				sb.append("INF").append('\n');
			}
		}
		System.out.print(sb);
	}
	
	static class Node implements Comparable<Node>{
		private int weight;
		public int end;
		
		public Node(int end, int weight) {
			this.weight = weight;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
