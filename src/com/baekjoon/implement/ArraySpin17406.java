package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArraySpin17406 {
	//틀린이유
	//tmp 한 가운데 칸을 안채워서 회전하고나면 0이됨
	//그리고 이거 배열 받는 족족 돌리는 문제가 아니라 나중에 뭐가 최소인지 순서 맞춰야하는 거였음
	
	static int N;
	static int M;
	static int K;
	
	static int[][] arr;
	static int[][] spins;
	static int[] order;
	static boolean[] check;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령어를 받으면 한칸씩 회전시키기?
		//새 미니 배열 만들어서 거기에 한칸씩 움직여서 놓은다음
		//그 미니배열로 덮어쓰기
		
		//명령을 저장했다가 백트래킹으로 최종 arr 복사본 가지고 돌려봐서 최소값이 몇인지 구하기
		//K <= 6 이니 기껏해야 경우의 수 720개
		
		
		spins = new int[K][3];
		order = new int[K];
		check = new boolean[K];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			spins[i][0] = r;
			spins[i][1] = c;
			spins[i][2] = s;
		}
		
		//그럼 이제 row의 합 최소만 찾으면 됨
		min = 5001;
		
		makeOrder(0);
		
//		for (int[] is : arr) {
//			for(int now : is) System.out.print(now+" ");
//			System.out.println();
//		}
		
		System.out.println(min);
	}
	
	static void makeOrder(int idx) {
		if(idx == K) {
			int[][] arrCopy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arrCopy[i][j] = arr[i][j];
				}
			}
			
			for (int i = 0; i < K; i++) {
				int now = order[i];
				spinArr(spins[now][0], spins[now][1], spins[now][2], arrCopy);
			}
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arrCopy[i][j];
				}
				min = Math.min(sum, min);
			}
			
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(!check[i]) {
				check[i] = true;
				order[idx] = i;
				makeOrder(idx+1);
				check[i] = false;
			}
		}
	}
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	static void spinArr(int r, int c, int s ,int[][] arr) {
		int[][] tmp =  new int[s*2+1][s*2+1];
		tmp[s][s] = arr[r][c];
		
		for (int len = s; len >= 1; len--) {
			int nr = r - len;
			int nc = c - len;
			int tmpR = s - len;
			int tmpC = s - len;
			
			for (int dir = 0; dir < 4; dir++) {
				for (int j = 0; j < len*2; j++) {
					tmpR += dr[dir];
					tmpC += dc[dir];
							
					tmp[tmpR][tmpC] = arr[nr][nc];
					
					nr += dr[dir];
					nc += dc[dir];
				}
			}
		}
		
		for (int row = r-s; row <= r+s; row++) {
			for (int col = c-s; col <= c+s; col++) {
				arr[row][col] = tmp[row-r+s][col-c+s];
			}
		}
	}
}
