package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MovePipe2_17069 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
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
		
		//0 = 가로, 1 = 세로, 2 = 대각선
		long[][][] sum = new long[N][N][3];
		
		for (int i = 1; i < N; i++) {
			if(arr[0][i] != 1)
				sum[0][i][0] = 1;
			else
				break;
		}
		
//		for (long[][] is : sum) {
//			for(long[] i : is) System.out.print(i[0] + " " + i[1] + " " + i[2] + " ");
//			System.out.println();
//		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(arr[i][j] == 1) continue;
				
				sum[i][j][0] = sum[i][j-1][0] + sum[i][j-1][2];
				
				sum[i][j][1] = sum[i-1][j][1] + sum[i-1][j][2];
				
				if(arr[i-1][j] != 1 && arr[i][j-1] != 1)
					sum[i][j][2] = sum[i-1][j-1][0] + sum[i-1][j-1][1] + sum[i-1][j-1][2];
			}
		}
		
		System.out.println(sum[N-1][N-1][0] + sum[N-1][N-1][1] + sum[N-1][N-1][2]);
	}
}
