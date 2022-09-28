package com.swea.d4;

import java.util.Arrays;
import java.util.Scanner;

public class MST_KRUSKAL_quickSort {
	
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
		
		//KRUSKAL, heap
		for (int tc = 1; tc <= T; tc++) {
			//입력 V : 정점의 수, E : 간선의 수
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			//간선들 저장용
			//배열에 일단 다 집어넣는다.
			Road[] roads = new Road[E];
			for (int i = 0; i < E; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				int w = sc.nextInt();
				
				roads[i] = new Road(st,ed,w);
			}
			//입력 끝
			
			//대빵 노드 저장용 - 1부터 시작함
			int[] root = new int[V+1];
			
			//나를 대표하는 사람은 나 자신
			//makeSet
			for (int i = 1; i <= V; i++) {
				root[i] = i;
			}
			
			//퀵소트(기성품) 해보기
			Arrays.sort(roads);
			
			//답안 저장용
			long ans = 0;
			int pick = 0;
			int idx = -1;
			
			//V개의 정점이면 MST의 간선수는 아마 정점보다 한개 적을 것
			while(pick != V-1) {
				idx++;
				Road now = roads[idx];
				
				int st = findSet(now.st , root);
				int ed = findSet(now.ed , root);
				
				//같은 소속임
				if(st == ed) 
					continue;
				
				//이게 유니온 아님?
				root[ed] = st;
				ans += now.w;
				
				pick++;
			}

			System.out.printf("#%d %d\n",tc,ans);
		}
		
		sc.close();
	}
	
	//저장하기
	static int findSet(int x, int[] root) {
		//내가 root다
		if(root[x] == x) return x;
		//root는 이쪽에 있다
		else return root[x] = findSet(root[x], root);
	}
}
