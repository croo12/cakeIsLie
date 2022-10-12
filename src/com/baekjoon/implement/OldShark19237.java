package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OldShark19237 {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Pair[][] arr = new Pair[N][N];
		Shark[] sharks = new Shark[M+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 0)
					arr[i][j] = new Pair(0,0);
				else {
					arr[i][j] = new Pair(K,now);
					sharks[now] = new Shark(i,j,now);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= M; i++) {
			sharks[i].state = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				int[] tmp = new int[4];
				st = new StringTokenizer(br.readLine());
				for (int l = 0; l < 4; l++) {
					tmp[l] = Integer.parseInt(st.nextToken()) - 1;
				}
				sharks[i].priority[j] = tmp;
			}
		}
		
		//1번 상어부터 주변을 탐색함 
		//주변 자리의 숫자가 sNum != no && (cnt 보다 작음) 인 칸을 현재 상태에 따른 우선순위에 맞춰 탐색
		//찾으면 이동
		//cnt인 칸이 없으면 sNum == no 인 칸을 탐색
		//찾으면 이동
		
		
		//모든 상어 다 돌았으면 상어가 있는 위치 sNum을 맞춰서 고침 
		//그리고 숫자를 cnt+K로 고침
		
		//숫자 고치려는 데 숫자가 cnt+K면 사망
		//사망시 shark--;
		
		//cnt++;
		
		//상하좌우 0123
		int cnt = 1;
		int shark = M;
		while(cnt <= 1000 && shark != 1) {
			for (int sk = 1; sk <= M; sk++) {
				Shark now = sharks[sk];
				if(now == null)
					continue;
				
				int[] p = now.priority[now.state];
				
				for (int k = 0; k < 8; k++) {
					int rr = now.r + dr[p[k%4]];
					int rc = now.c + dc[p[k%4]];
					
					if(rr >= N || rc >= N || rr < 0 || rc < 0) continue;
					
					Pair tmp = arr[rr][rc];
					//냄새 없는 곳 찾기
					if(k < 4 && tmp.num < cnt) {
						now.r = rr;
						now.c = rc;
						now.state = p[k%4];
						break;
					}
					//내 냄새인 곳 찾기
					if(k >= 4 && tmp.sNum == now.sNum) {
						now.r = rr;
						now.c = rc;
						now.state = p[k%4];
						break;
					}
				}
				
			}
			
			//상어자리 번호 바꾸기 //사망처리하기
			Shark now;
			for (int i = 1; i <= M; i++) {
				if((now = sharks[i]) != null) {
					if(arr[now.r][now.c].num == cnt + K) {
						sharks[now.sNum] = null;
						shark--;
					}else {
						arr[now.r][now.c].sNum = now.sNum;
						arr[now.r][now.c].num = cnt + K;
					}
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("=======================================================");
			
			cnt++;
		}
		
		if(shark == 1)
			System.out.println(--cnt);
		else
			System.out.println(-1);
	}
	static class Pair{
		int num,sNum;
		Pair(int num, int sNum){
			this.num = num;
			this.sNum = sNum;
		}
		
		@Override
		public String toString() {
			return "[ "+sNum+" : "+num+" ]";
		}
	}
	
	static class Shark{
		int r,c,sNum,state;
		int[][] priority;
		Shark(int r, int c, int sNum){
			this.r = r; 
			this.c = c;
			this.sNum = sNum; 
			priority = new int[4][];
		}
	}
}
