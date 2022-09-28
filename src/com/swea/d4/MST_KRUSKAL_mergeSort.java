package com.swea.d4;

import java.util.Scanner;

public class MST_KRUSKAL_mergeSort {
	//프림 힙, 프림 브루트(FAIL), 크루스칼힙, 크루스칼 퀵, 크루스칼 머지
	
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
		
		@Override
		public String toString() {
			return "[" + w + "]";
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
			
			//머지소트(수제) 해보기
			tmp = new Road[E];
			mergeSort(0,E-1,roads);
			
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
	
	static Road[] tmp;
	
	static void mergeSort(int st, int ed, Road[] roads) {
		if(st == ed) {
			tmp[st] = roads[st];
			return;
		}
		
		int mid = (st + ed)/2;
		mergeSort(st, mid, roads);
		mergeSort(mid+1, ed, roads);
		merge(st, ed, roads);
	}
	
	static void merge(int st, int ed, Road[] roads) {
		int mid = (st + ed)/2;
		
		int L = st;
		int R = mid+1;
		int idx = st;
		
		//작은걸 0번으로 오게 정렬할것임
		while(L <= mid && R <= ed) {
			if(roads[L].w <= roads[R].w) {
				tmp[idx] = roads[L];
				L++;
				idx++;
			}else {
				tmp[idx] = roads[R];
				R++;
				idx++;
			}
		}
		if(L <= mid)
			while(L <=mid) {
				tmp[idx] = roads[L];
				L++;
				idx++;
			}
		else
			while(R <= ed) {
				tmp[idx] = roads[R];
				R++;
				idx++;
			}
		
		for (int i = st; i <= ed; i++) {
			roads[i] = tmp[i];
		}
	}
	
	//저장하기
	static int findSet(int x, int[] root) {
		//내가 root다
		if(root[x] == x) return x;
		//root는 이쪽에 있다
		else return root[x] = findSet(root[x], root);
	}
}
