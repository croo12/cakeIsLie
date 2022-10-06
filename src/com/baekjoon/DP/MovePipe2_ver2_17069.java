package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MovePipe2_ver2_17069 {
	
	static long[][][] sum;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//현재 칸 r,c로 오는 방법의 수는
		//r-1, c로 오는 방법의 수 중 가로모양이 아닌것 + -> 나에게 세로모양으로 옴
		//r, c-1로 오는 방법의 수 중 세로모양이 아닌것 + -> 나에게 가로모양으로 옴
		//r-1,c-1로 오는 모든 방법의 수이다.       -> 나에게 대각선 모양으로 옴
		
		//벽도 신경써야함
		
		sum = new long[N][N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					sum[i][j][j2] = -1;
				}
			}
		}
		sum[0][1][0] = 1;
		//0 = 가로, 1 = 세로, 2 = 대각선
		long ans = findWay(N-1, N-1, 0) + findWay(N-1, N-1, 1) + findWay(N-1, N-1, 2);
		
		System.out.println(ans);
	}
	
	static long findWay(int r, int c, int pos) {
		if(arr[r][c] == 1)
			return 0L;
		
		if(sum[r][c][pos] != -1) {
			return sum[r][c][pos];
		}
		
		if(pos == 0 && c != 0) {
			return sum[r][c][pos] = findWay(r, c-1, 0) + findWay(r, c-1, 2);
		}
		
		if(pos == 1 && r != 0) {
			return sum[r][c][pos] = findWay(r-1, c, 1) + findWay(r-1, c, 2);
		}
		
		if(pos == 2 && r != 0 && c != 0 && arr[r-1][c] != 1 && arr[r][c-1] != 1) {
			return sum[r][c][pos] = findWay(r-1, c-1, 0) + findWay(r-1, c-1, 1) + findWay(r-1, c-1, 2);
		}
		
		return 0L;
	}
}
