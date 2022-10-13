package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IceMountain2573 {
	
	static int[][] arr;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		//빙산은 10000칸 이하임 최대 90000칸
		//빙산 덩어리클래스 만들고 변경내용기록한다음 나중에 빙산에 반영하기
		//그리고 매일 dfs체크하기
		
		ArrayList<Ice> ice = new ArrayList<>();
		arr = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now != 0 ) {
					arr[i][j] = now;
					ice.add(new Ice(i,j,now));
				}
			}
		}
		
		//아직 한도막임
		boolean flag = true;
		int size = ice.size();
		int cnt = 0;
		while(flag && size != 0) {
			
			//사방 탐색해서 높이 줄이기
			for (int i = size - 1; i >= 0; i--) {
				Ice now = ice.get(i);
				
				for (int k = 0; k < 4; k++) {
					int rr = now.r + dr[k];
					int rc = now.c + dc[k];
					
					if(arr[rr][rc] == 0) {
						now.h--;
					}
				}
			}
			
			//사라진 빙산 제거하기
			for (int i = size - 1; i >= 0; i--) {
				Ice now = ice.get(i);
				
				if(now.h > 0) {
					arr[now.r][now.c] = now.h;
					continue;
				}
				
				ice.remove(i);
				arr[now.r][now.c]  = 0;
				size--;
			}
			
			//빙산 두도막임?
			if(size != 0) {
				num = 0;
				vis = new boolean[R][C];
				Ice one = ice.get(0);
				dfs(one.r,one.c);
				if(num < size)
					flag = false;
			}
			
			cnt++;
		}
		
		if(flag) {
			System.out.println(0);
		}else
			System.out.println(cnt);
	}
	
	static int num;
	static boolean[][] vis;
	
	static void dfs(int r, int c) {
		vis[r][c] = true;
		num++;

		for (int k = 0; k < 4; k++) {
			int rr = r + dr[k];
			int rc = c + dc[k];
			
			if(arr[rr][rc] != 0 && !vis[rr][rc]) {
				dfs(rr,rc);
			}
		}
	}
	
	static class Ice{
		int r,c,h;
		Ice(int r, int c, int h){
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
}
