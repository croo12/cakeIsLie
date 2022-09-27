package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gerrymandering17471 {
	
	static ArrayList<Integer>[] roads;
	static int N;
	static int[] pop;
	
	static int totalPop;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N+1];
		
		totalPop = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			totalPop += (pop[i] = Integer.parseInt(st.nextToken()));
		}
		
		roads = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			roads[i] = new ArrayList<>();
			
			for (int j = 0; j < M; j++) {
				int side = Integer.parseInt(st.nextToken());
				roads[i].add(side);
			}
		}
		
		min = Integer.MAX_VALUE;
		//구역을 두개로 쪼갠다  -> 차이가 몇인지 계산한다.
		//구역을 두개로 쪼개기(조합) -> 이 쪼갠 구역이 가능한지 체크(dfs) -> 차이가 몇인지 계산
		//N <= 10 // 최대 간선 45개  // 0.5초... 되나 이거
		
		for (int i = 1; i <= N/2; i++) {
			check = new boolean[N+1];
			comb(0,1,0,i);
//			System.out.println(i + " : " + min);
		}
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static boolean[] check;
	static int min;
	
	private static void comb(int depth, int idx, int sum ,int max) {
		
		
		if(depth == max) {
			if(Math.abs(totalPop - sum*2) >= min)
				return;
			
			boolean[] tmp = check.clone();
			
			
			
			//나머지 부분이 하나인지 확인하기
			for (int i = 1; i <= N; i++) {
				if(!tmp[i]) {
					dfs(i,tmp);
					break;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(!tmp[i])
					return;
			}
			
			min = Math.min(Math.abs(totalPop - sum*2), min);
			return;
		}
		
		if(idx >= N)
			return;
		
		check[idx] = true;
		comb(depth + 1, idx + 1, sum + pop[idx], max);
		check[idx] = false;
		comb(depth, idx+1, sum, max);
	}
	
	private static void dfs(int now, boolean[] tmpCheck) {
		if(tmpCheck[now]) {
			return;
		}else {
			tmpCheck[now] = true;
		}
		
		ArrayList<Integer> list = roads[now];
		
		for (int i = 0; i < list.size(); i++) {
			int tmp = list.get(i);
			if(!tmpCheck[tmp]) {
				dfs(tmp,tmpCheck);
			}
		}
	}
}
