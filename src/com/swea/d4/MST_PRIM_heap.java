package com.swea.d4;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MST_PRIM_heap {
	
	static class Road implements Comparable<Road>{
		int st,ed,w;
		Road(int st, int ed, int w){
			this.st = st;
			this.ed = ed;
			this.w = w;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		//PRIM, heap
		for (int tc = 1; tc <= T; tc++) {
			//입력 V : 정점의 수, E : 간선의 수
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			//간선들 저장용
			ArrayList<Road>[] roads = new ArrayList[V+1];//1부터 시작함
			for (int i = 1; i <= V; i++) {
				roads[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				int w = sc.nextInt();
				
				roads[st].add(new Road(st,ed,w));
				roads[ed].add(new Road(ed,st,w));
			}
			//입력 끝
			
			
			//이미 최솟값 찾은건 배제하자
			boolean[] vis = new boolean[V+1];
			//힙(기성품)
			PriorityQueue<Road> pq = new PriorityQueue<>();
			pq.addAll(roads[1]);
			vis[1] = true;
			
			//답안 저장용
			long ans = 0;
			int pick = 1;
			
			while(pick != V) {
				//지금 들어있는 녀석중에 제일 작은놈이 나온다
				Road now = pq.poll();
				
				if(vis[now.ed]) continue;
				
				ans += now.w;
				pq.addAll(roads[now.ed]);
				vis[now.ed] = true;
				pick++;
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}
		
		sc.close();
	}
}
