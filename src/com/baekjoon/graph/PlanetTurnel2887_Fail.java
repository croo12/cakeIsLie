package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PlanetTurnel2887_Fail {
	//틀렸다
	//3%에서 메모리 초과남
	
	static final long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//중점을 연결하는 모든 간선 N*(N-1)/2
		//N <= 100,000
		//모든 중점은 N-1개의 간선으로 연결했을 때 
		//간선의 가중치가 최소가 되는 경우의 수는?
		
		//최소 스패닝 트리를 찾는 문제
		
		//간선이 짱 많으니 프림이겠지
		//근데 N = 100000이면 시간안에 될까
		//일단 해보자
		
		int[][] vt = new int[N][3];
		boolean[] vis = new boolean[N];
		StringTokenizer st;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			vt[i][0] = Integer.parseInt(st.nextToken());
			vt[i][1] = Integer.parseInt(st.nextToken());
			vt[i][2] = Integer.parseInt(st.nextToken());
		}
		
		pq.offer(new Edge(0, 0));
		int ans = 0;
		int cnt = -1;
		
		Edge now;
		long min;
		while(true) {
			now = pq.poll();
			
			if(vis[now.ed]) continue;
			vis[now.ed] = true;
			ans += now.dist;
			
			if(++cnt == N-1)
				break;
			
			for (int i = 1; i < N; i++) {
				if(!vis[i]) {
					min = INF;
					for (int j = 0; j < 3; j++) {
						min = Math.min(min, Math.abs((long)vt[now.ed][j] - vt[i][j]));
					}
					pq.offer(new Edge(i, min));
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static class Edge implements Comparable<Edge>{
		int ed;
		long dist;

		public Edge(int ed, long dist) {
			this.ed = ed;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}
	}
}
