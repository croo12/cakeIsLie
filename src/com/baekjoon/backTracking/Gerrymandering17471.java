package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gerrymandering17471 {
	//틀린 이유 
	//1 : 1번 선거구는 연결상태인지 체크했지만 2번 선거구는 체크안함
	//2 : 1번부터 N번까지 인덱스를 해놓고선 막상 조합은 0~9까지함

	static ArrayList<Integer>[] roads;
	static int N;
	static int[] pop;

	static boolean[] check;
	static int total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N + 1];
		check = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			total += pop[i] = Integer.parseInt(st.nextToken());
		}

		roads = new ArrayList[N + 1];
		

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			roads[i] = new ArrayList<>();

			for (int j = 0; j < M; j++) {
				int side = Integer.parseInt(st.nextToken());
				roads[i].add(side);
			}
		}

		// 모든 경우의 수 조합하기
		// 가능한 방법인지 체크하기 (선거구 1과 선거구 2가 완전히 이어져 있는가?)
		// 인구 차이의 최소값(여태까지)보다 더 낮은지 체크하고 갱신하기
		
		min = 900;
		
		comb(0,1,0);
		
		if(min == 900)
			System.out.println(-1);
		else{
			System.out.println(min);
		}

	}
	
	static int min;

	private static void comb(int depth, int idx, int sum) {
		if(sum - (total - sum) > min)
			return;
		
		if (idx > N || depth == N/2) {
			
//			if(Math.abs(sum - (total - sum)) == 15) {
//				System.out.println(Arrays.toString(check));
//				System.out.println(Math.abs(sum - (total - sum)));
//			}
//			
			//dfs를 두번해서 얘네가 각각 다 이어져있는지 해보기
			boolean[] otherChk = new boolean[N+1];
			
			boolean flag1 = false;
			boolean flag2 = false;
			for (int i = 1; i <= N; i++) {
				if(check[i] && !flag1) {
					flag1 = true;
					dfs(i, otherChk, true);
				}else if(!check[i] && !flag2) {
					flag2 = true;
					dfs(i, otherChk, false);
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(!otherChk[i])
					return;
			}
			
			min = Math.min(min, Math.abs(sum - (total - sum)));
			
			return;
		}

		check[idx] = true;
		comb(depth + 1, idx + 1, sum + pop[idx]);
		check[idx] = false;
		comb(depth, idx + 1, sum);
	}
	
	private static void dfs(int now, boolean chk[], boolean team) {
		if(chk[now] || check[now] != team)
			return;
		
		chk[now] = true;
		
		ArrayList<Integer> list = roads[now];
		int len = list.size();
		for (int i = 0; i < len; i++) {
			int next = list.get(i);
			dfs(next, chk, team);
		}
	}
}
