package com.jungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Religion {
	static int[] p;
	static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(sc.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		rank = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(sc.readLine());
			int left = findSet(Integer.parseInt(st.nextToken()));
			int right = findSet(Integer.parseInt(st.nextToken()));
//			if(left == right)
//				continue;
			union(left, right);
		}
		
		int cnt = 0;
		for (int i = 1; i < N+1; i++) {
			if(p[i] == i)
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static void union(int left, int right) {
		if(rank[left] > rank[right]) {
			p[right] = left;
		}else {
			p[left] = right;
			if(rank[left] == rank[right])
				rank[left]++;
		}
	}
	
	static int findSet(int x) {
		if(p[x] == x) return x;
		return p[x] = findSet(p[x]);
	}
}
