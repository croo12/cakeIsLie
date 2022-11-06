package com.baekjoon.dataStructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class RaindropOnTree17073 {
	public static void main(String[] args) {
		try {
			new RaindropOnTree17073().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		Node[] tree = new Node[N+1];
		Edge[] adjList = new Edge[N+1];
		int[] count = new int[N+1];
		boolean[] vis = new boolean[N+1];
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			adjList[left] = new Edge(right, adjList[left]);
			adjList[right] = new Edge(left, adjList[right]);
			count[left]++;
			count[right]++;
		}
		
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i);
			count[i]--;
		}
		
		count[1]++;
		tree[1].w = W;
		
		//자식이 받는 물의 기대값은 항상 1/형제들의 수
		//그냥 자식들한테 다 물  w/자식 수 만큼 씩 뿌리고 마지막에 형제들의 수로 나누면 되는게 아닌가
		
		Queue<Node> q = new ArrayDeque<>();
		vis[1] = true;
		q.offer(tree[1]);
		
		Node now;
		while(!q.isEmpty()) {
			now = q.poll();
			
			if(count[now.num] == 0)
				continue;
			
			double predict = now.w/count[now.num];
			now.w = 0;
			for(Edge e = adjList[now.num]; e != null; e = e.next) {
				if(!vis[e.ed]) {
					vis[e.ed] = true;
					tree[e.ed].w = predict;
					q.offer(tree[e.ed]);
				}
			}
		}
		
		double sum = 0.0;
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(tree[i].w > 0) {
				sum += tree[i].w;
				cnt++;
			}
		}
		
		System.out.println(sum/cnt);
	}
	
	class Edge{
		int ed;
		Edge next;
		Edge(int ed, Edge next){
			this.ed = ed;
			this.next = next;
		}
	}
	
	class Node{
		int num, size;
		double w;
		
		public Node(int num) {
			this.num = num;
		}
	}
}
