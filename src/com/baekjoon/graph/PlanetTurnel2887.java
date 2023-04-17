package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PlanetTurnel2887 {
	//틀렸다
	//3%에서 메모리 초과남

	static final long INF = Long.MAX_VALUE;
	static int N;
	static int[][] vt;
	static PriorityQueue<Edge> pq;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		//중점을 연결하는 모든 간선 N*(N-1)/2
		//N <= 100,000
		//모든 중점은 N-1개의 간선으로 연결했을 때
		//간선의 가중치가 최소가 되는 경우의 수는?

		//최소 스패닝 트리를 찾는 문제

		//간선이 짱 많으니 프림이겠지
		//근데 N = 100000이면 시간안에 될까
		//일단 해보자

		vt = new int[N][4];
		boolean[] vis = new boolean[N];
		StringTokenizer st;

		//행성들
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			vt[i][0] = Integer.parseInt(st.nextToken());
			vt[i][1] = Integer.parseInt(st.nextToken());
			vt[i][2] = Integer.parseInt(st.nextToken());
			vt[i][3] = i;
		}

		pq = new PriorityQueue<>();

		//0, 1, 2//
		sortAndAdd(0);
		sortAndAdd(1);
		sortAndAdd(2);

		//init kruskal
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}

		int ans = 0;
		int cnt = 0;

		Edge now;
		int start, end;
		while(true) {
			now = pq.poll();
			start = find(now.st);
			end = find(now.ed);

			//need union?
			if (start != end){
				p[end] = start;
				ans += now.dist;
				cnt++;
			}

			if ( cnt == N-1 )
				break;

		}

		System.out.println(ans);
	}

	static void sortAndAdd(int number) {
		Arrays.sort(vt, Comparator.comparingInt(o -> o[number]));
		for (int i = 0; i < N - 1; i++) {
			long dist = Math.abs(vt[i][number] - vt[i+1][number]);
			pq.offer(new Edge(vt[i][3], vt[i+1][3], dist));
			pq.offer(new Edge(vt[i+1][3], vt[i][3], dist));
		}
	}

	static int find(int id){
		if ( p[id] != id ){
			p[id] = find(p[id]);
		}

		return p[id];
	}

	static class Edge implements Comparable<Edge>{
		int st, ed;
		long dist;

		public Edge(int st, int ed, long dist) {
			this.st = st;
			this.ed = ed;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}
	}
}
