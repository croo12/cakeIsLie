package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bishop1799_ver2 { //메모리초과
	static int N;
	static int[][] arr;
//	static int ones;
	static int max;
	
//	static int[] arrX = new int[100];
//	static int[] arrY = new int[100];
	
	static int[] dx = {-1,-1,1,1};
	static int[] dy = {1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
//		ones = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				if(arr[i][j] == 1) {
//					arrX[ones] = j;
//					arrY[ones] = i;
//					ones++;
//				}
			}
		}

		doIt(0,0,0);
		System.out.println(max);
	}
	
	private static void doIt(int x, int y, int cnt) {
		if(x == N && y == N-1) {
			max = Math.max(cnt, max);
			return;
		}
		
		if(x == N) {
			System.out.println(y);
			doIt(0, y+1, cnt);
			return;
		}
		
//		if(ones + cnt < max) return;
		
//		int tmp = 0;
		if(arr[y][x] == 1) {
			int[] endX = new int[4];
			int[] endY = new int[4];
			
			for (int k = 0; k < 4; k++) {
				int nx = x;
				int ny = y;
				while(nx < N && nx >=0 && ny < N && ny >= 0) {
					
					if(arr[ny][nx] == 1) {
						arr[ny][nx] = cnt + 2;
//						tmp++;
					}
					
					nx = nx + dx[k];
					ny = ny + dy[k];
				}
				
				endX[k] = nx;
				endY[k] = ny;
			}
//			ones -= tmp;
			
			doIt(x+1,y,cnt+1);
			
//			ones += tmp;
			
			for (int k = 0; k < 4; k++) {
				int nx = endX[k] - dx[k];
				int ny = endY[k] - dy[k];
				while(nx != x && ny != y) {
					
					if(arr[ny][nx] == cnt + 2) {
						arr[ny][nx] = 1;
					}
					
					nx = nx - dx[k];
					ny = ny - dy[k];
				}
			}
			arr[y][x] = 1;			
			doIt(x+1,y,cnt);
		}else
			doIt(x+1,y,cnt);		
	}
}
