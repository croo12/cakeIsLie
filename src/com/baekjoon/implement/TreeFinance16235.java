package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeFinance16235 {
	
	static int K;
	
	public static void main(String[] args) throws IOException {
		//상도와 S2D2
		//N*N의 땅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N 넓이 //M 나무 수  //K K년 후
		int N = Integer.parseInt(st.nextToken()),M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Land[][] arr = new Land[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int s2d2 = Integer.parseInt(st.nextToken());
				arr[i][j] = new Land(s2d2);
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int old = Integer.parseInt(st.nextToken());
			arr[r][c].addTree(old);
		}
		
		int[] dr = {0,0,-1,-1,-1,1,1,1};
		int[] dc = {1,-1,-1,0,1,-1,0,1};
		
		int cnt = 0;
		while(cnt++ < K) {
			//봄
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j].spring();
				}
			}
			
			//가을
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = arr[i][j].fall();
					
					for (int k = 0; k < 8; k++) {
						int rr = i + dr[k];
						int rc = j + dc[k];
						
						if(rr >= N || rc >= N || rr < 0 || rc < 0) continue;
						
						arr[rr][rc].addTree(1, num);
					}
				}
			}
		}
		
		System.out.println(Land.size);
	}
	
	static class Land{
		static int size;
		final int MAX;
		int yang_boon;
		int[] trees;
		int dead;
		int s2d2;
		Land(int s2d2){
			this.yang_boon = 5;
			MAX = K+12;
			this.trees = new int[MAX];
			this.dead = 0;
			this.s2d2 = s2d2;
		}
		
		void spring() {
			int idx = -1;
			for (int i = 1; i < MAX; i++) {
				if(idx == -1) {
					int tmp = yang_boon/i;
					//양분이 트리보다 많음
					if(tmp >= trees[i]) {
						yang_boon -= trees[i]*i;
					}else {
						yang_boon -= tmp*i;
						
						int deadNum = trees[i] - tmp;

						trees[i] -= deadNum;
						size -= deadNum;
						dead += (i/2) * deadNum;
						
						idx = i;
					}
				}else {
					dead += (i/2) * trees[i];
					size -= trees[i];
					trees[i] = 0;
				}
			}
			
			if(idx == -1) idx = MAX-1;
			else idx++;
			
			for(int i = idx; i >= 1; i--) {
				trees[i] = trees[i - 1];
			}
			
			yang_boon += dead + s2d2;
			dead = 0;
		}
		
		int fall() {
			int sum = 0;
			for (int i = 5; i < MAX; i+=5) {
				sum += trees[i];
			}
			return sum;
		}
		
		void addTree(int i) {
			trees[i]++;
			size++;
		}
		
		void addTree(int i , int num) {
			trees[i] += num;
			size += num;
		}
	}
	
	
}
