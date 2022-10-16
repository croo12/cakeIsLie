package com.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChickenDelivery15686 {
	
	static int hCnt;
	static int cCnt;
	
	static int M;
	
	static Pair[] house;
	static Pair[] chicken;
	
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//치킨집 중 M개의 치킨집을 골라서 최단거리합이 가장 짧은 것 구하기
		//집의 개수는 최대 2N개 -> 듬성듬성있음
		//치킨집의 개수는 최대 13 -> 그렇게 많이 계산하는거 아님~
		
		//치킨집이랑 집 클래스만들어서 거리 비교하기
		//그 다음 M개 고르는거 뭐가 제일 거리 짧은지 비교하면됨
		
		house = new Pair[2*N];
		chicken = new Pair[13];
		
		hCnt = 0;
		cCnt = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 1)
					house[hCnt++] = new Pair(i,j);
				else if(now == 2)
					chicken[cCnt++] = new Pair(i,j);
			}
		}
		
		check = new boolean[13];
		ans = 10000;
		
		comb(0,0);

		System.out.println(ans);
	}
	
	static int ans;
	
	static void comb(int depth, int idx) {
		if(depth == M) {
			//거리재기
			
			int sum = 0;
			int r;
			int c;
			int min;
			for (int i = 0; i < hCnt; i++) {
				r = house[i].r;
				c = house[i].c;
				min = 100;
				
				for (int j = 0; j < cCnt; j++) {
					if(check[j])
						min = Math.min(min, Math.abs(r-chicken[j].r) + Math.abs(c-chicken[j].c));
				}
				
				sum += min;
			}
			
			ans = Math.min(sum, ans);
			return;
		}
		
		if(M-depth > cCnt-idx)
			return;
		
		check[idx] = true;
		comb(depth+1,idx+1);
		check[idx] = false;
		comb(depth,idx+1);
	}
	
	static class Pair{
		int r,c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
