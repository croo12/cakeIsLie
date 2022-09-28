package com.swea.d4;

import java.util.ArrayList;
import java.util.Scanner;

public class MST_PRIM_brute {
	//시간초과 나는데?
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
			//간선 길이 모음?
			int[] dis = new int[V+1];
			for (int i = 1; i <= V; i++) {
				dis[i] = Integer.MAX_VALUE;
			}
			
			//1번부터 시작함
			dis[1] = 0;
			//답안 저장용
			long ans = 0;
			
			int pick = 1;
			
			while(pick != V) {
				int min = Integer.MAX_VALUE;
				int idx = -1;
				//한바퀴 돌면서 다음 타자 찾기
				for (int i = 1; i <= V; i++) {
					if(!vis[i] && dis[i] < min) {
						min = dis[i];
						idx = i;
					}
				}
				vis[idx] = true;
				
				for (Road r : roads[idx]) {
					if(!vis[r.ed] && dis[r.ed] > r.w)
						dis[r.ed] = r.w;
				}
				
				pick++;
			}
			
			for (int i = 1; i <= V; i++) {
				ans += dis[i];
			}
			
			System.out.printf("#%d %d\n",tc,ans);
		}
		
		sc.close();
	}
}
