package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
		Road[] pq = new Road[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq[i] = new Road(a, b, w);
		}
		Arrays.sort(pq);
		
		root = new Subset[V+1];
		for (int i = 1; i <= V; i++) {
			root[i] = new Subset(i, 0);
		}
		
		int ans = 0;
		int pick = 0;
		int idx = -1;
		while(true) {
			Road now = pq[++idx];
			int left = findSet(now.st);
			int right = findSet(now.ed);
			if(left == right)
				continue;
			
			union(left, right);
			ans+= now.w;
			if(++pick == V-1) {
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	static Subset[] root;
	
	static void union(int x, int y) {
		if(root[x].rank > root[y].rank) {
			root[y].root = x;
		}else if(root[x].rank < root[y].rank) {
			root[x].root = y;
		}else {
			root[y].root = x;
			root[x].rank++;
		}
	}
	
	static int findSet(int x) {
		if(root[x].root == x) return x;
		return root[x].root = findSet(root[x].root);
	}
	
	static class Subset{
		int root, rank;
		Subset(int root, int rank){
			this.root = root;
			this.rank = rank;
		}
	}
	
	static class Road implements Comparable<Road>{
		int st, ed, w;
		Road(int st,int ed, int w){
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		@Override
		public int compareTo(Road o) {
			return this.w - o.w;
		}
	}
}
