package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MathAnd2DArray17140 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		int row = 3;
		int col = 3;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()) - 1;
		int C = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while (arr[R][C] != k && cnt < 100) {
			
			int longest = 0;
			//정렬 하기
			for (int i = 0; i < 100; i++) {
				if(row < col && i == col || row >= col && i == row)
					break;
				
				PriorityQueue<Pair> pq = new PriorityQueue<>();
				int[] count = new int[101];

				if (row < col) {
					for (int j = 0; j < row; j++) {
						count[arr[j][i]]++;
					}
				} else {
					for (int j = 0; j < col; j++) {
						count[arr[i][j]]++;
					}
				}

				//pq에 넣기
				for (int j = 1; j <= 100; j++) {
					if (count[j] != 0) {
						pq.offer(new Pair(j, count[j]));
					}
				}
				
//				System.out.println("현재 i = "+ i);
//				System.out.println(pq);
				
				if (row < col) {
					for (int j = 0; j < 100; j+=2) {
						if(!pq.isEmpty()) {
							Pair now = pq.poll();
							arr[j][i] = now.number;
							arr[j+1][i] = now.cnt;
							longest = Math.max(j+2, longest);
						}else {
							arr[j][i] = 0;
							arr[j+1][i] = 0;
						}
					}
				} else {
					for (int j = 0; j < 100; j+=2) {
						if(!pq.isEmpty()) {
							Pair now = pq.poll();
							arr[i][j] = now.number;
							arr[i][j+1] = now.cnt;
							longest = Math.max(j+2, longest);
						}else {
							arr[i][j] = 0;
							arr[i][j+1] = 0;
						}
					}
				}
			}
			
			if(row < col) {
				row = longest;
			}else {
				col = longest;
			}

//			System.out.printf("row : %d , col : %d\n" , row, col);
//			for (int i = 0; i <= row; i++) {
//				for(int j = 0; j <= col; j++) System.out.print(arr[i][j]+" ");
//				System.out.println();
//			}
			
			cnt++;
		}
		if(arr[R][C] == k)
			System.out.println(cnt);
		else
			System.out.println(-1);
	}

	static class Pair implements Comparable<Pair> {
		int number;
		int cnt;

		Pair(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pair o) {
			int one = Integer.compare(this.cnt, o.cnt);
			if (one == 0) {
				return Integer.compare(this.number, o.number);
			}
			return one;
		}
		
		@Override
		public String toString() {
			return "[" + number + " , " + cnt + "]";
		}
	}
}
