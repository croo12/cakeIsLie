package com.elses.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			int N = sc.nextInt();
			int[][] arr = new int[N + 2][N + 2];
			// 디폴트 값
			arr[N / 2][N / 2] = arr[N / 2 + 1][N / 2 + 1] = 2;
			arr[N / 2][N / 2 + 1] = arr[N / 2 + 1][N / 2] = 1;

			// 돌을 놓는 횟수
			int M = sc.nextInt();

			int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
			int nr, nc;

			for (int i = 0; i < M; i++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				// 1 이면 흑돌, 2 이면 백돌
				int type = sc.nextInt();

				// 돌을 놓을 때
				arr[row][col] = (type == 1 ? 1 : 2);

//				System.out.println("----------------돌 놓음------------------");
//				for (int[] is : arr) {
//					for (int l : is)
//						System.out.print(l + " ");
//					System.out.println();
//				}
//				System.out.println("--------------------------------------");

				// 8 방 탐색을 한다
				for (int d = 0; d < 8; d++) {
					int k = 1;

					nr = row + dr[d];
					nc = col + dc[d];

					// 옆에 다른 색 돌이 있다면 while 반복문 시작
					if (arr[nr][nc] == (type == 1 ? 2 : 1)) {
						boolean flag = true;

						while (flag) {
							k++;
//                          nr = nc = 0;
							nr = nr + dr[d];
							nc = nc + dc[d];

							// 다시 같은 색 돌을 만났으면
							if (arr[nr][nc] == (type == 1 ? 1 : 2)) {
								// 돌아온 길을 다 같은 색 돌로 바꾼다
								while (k > 1) {
									k--;
									 nr = row + (k * dr[d]);
                                     nc = col + (k * dc[d]);

									arr[nr][nc] = (type == 1 ? 1 : 2);
								}
								flag = false;
							}
							// 벽을 만났을 때 멈춰
							else if (arr[nr][nc] == 0) {
								flag = false;
							}
							// 다른 색 돌이 나왔을 때는 계속 ㄱㄱ
							else {
								continue;
							}
						} // while 문 끝
					}
				}

				System.out.println("--------------------------------------");
				for (int[] is : arr) {
					for (int l : is)
						System.out.print(l + " ");
					System.out.println();
				}
				System.out.println("--------------------------------------");
				
			}
			int black = 0;
			int white = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] == 1) {
						black++;
					} else if (arr[i][j] == 2){
						white++;
					}
				}
			}
			sb.append(black + " " + white);
			System.out.println(sb);
			sb.setLength(0);
		} // 테스트케이스 for문
		sc.close();
	}
}