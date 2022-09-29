package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Hana_Ro_ver1 {
	
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			//섬의 수
			int V = Integer.parseInt(br.readLine());
			
			int[] col = new int[V];
			int[] row = new int[V];
			p = new int[V+1];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				col[i] = Integer.parseInt(st1.nextToken());
				row[i] = Integer.parseInt(st2.nextToken());
				//makeSet
				p[i+1] = i+1;
			}
			double E = Double.parseDouble(br.readLine());
			
			PriorityQueue<Road> pq = new PriorityQueue<>();
			
			for (int i = 0; i < V-1; i++) {
				for (int j = i+1; j < V; j++) {
					long colDiff = col[i] - col[j];
					long rowDiff = row[i] - row[j];
					pq.offer(new Road(i+1,j+1, colDiff*colDiff+ rowDiff*rowDiff));
				}
			}
			
			int pick = 0;
			double ans = 0.0;
			while(true) {
				Road now = pq.poll();
				int st = findSet(now.st);
				int ed = findSet(now.ed);
				
				if(st == ed)
					continue;
				
				//union
				p[ed] = st;
				ans += now.w;
				
				if(++pick == V-1)
					break;
			}
			
			sb.append(String.format("#%d %d\n",tc , Math.round(ans*E)));
		}
		System.out.print(sb);
	}
	
	static int findSet(int x) {
		if(p[x] != x) 
			return p[x] = findSet(p[x]);
		else return x;
	}
	
	static class Road implements Comparable<Road>{
		int st,ed;
		long w;
		Road(int st,int ed, long w){
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		@Override
		public int compareTo(Road o) {
			return Long.compare(this.w, o.w);
		}
	}
}
