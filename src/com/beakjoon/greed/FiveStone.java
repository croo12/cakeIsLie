package com.beakjoon.greed;

import java.util.Scanner;

public class FiveStone { //http://colorscripter.com/s/E4Eac4L //브루트포스 알고리즘

	static int winner=0;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[][] board = new int[19][19];
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int[] pair = win_checker(board);
		if(pair == null) {
			System.out.println(0);
		}else {
			System.out.println(winner);
			System.out.println((pair[0]+1) + " " + (pair[1]+1));
		}
		
		sc.close();
	}
	
	public static int[] win_checker(int[][] board) {
		int[] pair = {19,19};
		
		int[] dx = {0,1,1,-1};
		int[] dy = {1,0,1,1}; //아래, 오른쪽, 남동, 남서
		
		int[] x = new int[5];
		int[] y = new int[5];
		
		int cnt = 1;
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(board[i][j] != 0) {
					for (int move = 0; move < 4; move++) {
						cnt = 1;
						int next_x = i + dx[move];
						int next_y = j + dy[move];
						if(next_x < 0 || next_x >= 19 || next_y < 0 || next_y >= 19) {}
						else if(board[next_x][next_y] == board[i][j]) {
							x[0] = i; y[0] = j;
							x[1] = next_x; y[1] = next_y;
							for (int k = 0; k < 4; k++) {
								next_x += dx[move];
								next_y += dy[move];
								if(next_x < 0 || next_x >= 19 || next_y < 0 || next_y >= 19) {}
								else if(board[next_x][next_y] == board[i][j]) {
									if(k==3) {
										cnt++;
										break;
									}else {
										x[2+k] = next_x;
										y[2+k] = next_y;
										cnt++;
									}
								}else {
									break;
								}
							}
						}

						if(cnt == 4) {
							int rx = i-dx[move];
							int ry = j-dy[move];
							if(rx < 0 || rx >= 19 || ry < 0 || ry >= 19) {}
							else if(board[rx][ry] == board[i][j]) {
								continue;
							}
							for (int k = 0; k < 5; k++) {
								if(x[k] <= pair[0] && y[k] <= pair[1]) {
									pair[0] = x[k];
									pair[1] = y[k];
								}
							}
							winner = board[i][j];
							return pair;
						}	
					}
				}	
			}
		}
		return null;
	}
}
