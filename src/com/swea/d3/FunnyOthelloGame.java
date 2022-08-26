package com.swea.d3;

import java.util.Scanner;

public class FunnyOthelloGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] rx = { 0, 0, 1, 1, 1, -1, -1, -1 };
		int[] ry = { 1, -1, 0, 1, -1, 0, 1, -1 };
		//아래, 위, 오른, 오른아래, 오른위, 왼, 왼아래,왼위

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			arr[N / 2 -1][N / 2 -1] = arr[N / 2][N / 2] = -1;
			arr[N / 2 -1][N / 2] = arr[N / 2][N / 2 -1] = 1;

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				
				int now = sc.nextInt();
				if(now == 2) now = -1;
					arr[y][x] = now;
//					System.out.println(x +" 그리고 "+y);
				//Search : 
				for (int j = 0; j < 8; j++) {
					int k = 1;
					int[][] records = new int[N][2];
					while (k != 0) {
						int nx = x + k * rx[j];
						int ny = y + k * ry[j];

						records[k - 1][0] = nx;
						records[k - 1][1] = ny;
						if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
//						System.out.println(nx +" 그리고 "+ny +" 의 값 : "+ arr[ny][nx]);
						if (arr[ny][nx] == now * -1)
							k++;
						else if (arr[ny][nx] == 0)
							break;
						else if (arr[ny][nx] == now){
							for (int l = 0; l < k; l++) {
								if(records[l][1] != 0 || records[l][0] != 0)
									arr[records[l][1]][records[l][0]] = now;
							}
							break;
						}
					}
				}
				//출력해보기
//				System.out.println("-----------------------------");
//				for (int[] is : arr) {
//					for(int in : is) System.out.print(in+" ");
//					System.out.println();
//				}
//				System.out.println("-----------------------------");
			}
			int bCnt = 0;
			int wCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 1)
						bCnt++;
					else if(arr[i][j] == -1)
						wCnt++;
				}
			}
			System.out.printf("#%d %d %d\n",tc,bCnt,wCnt);
		}
		sc.close();
	}
}
