package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku2580_FAIL { // 실패
	static int[][] board;
//	static int cnt;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];

		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
//				if (board[i][j] == 0) {
//					cnt++;
//				}
			}
		}
		
		goBackT(0,0);
	}
	
	static void goBackT(int y, int x) {
		if(y == 9 && x == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.print(sb);
			flag = true;
			return;
		}
		
		if(flag) return;
		
		if(board[y][x] == 0)
			for (int i = 1; i <= 9; i++) {
				if(check(x, y, i)) {
					board[y][x] = i;
					if(x== 8) goBackT(y+1,0); 
					else goBackT(y,x+1);
					board[y][x] = 0;
				}
			}
		else
			if(x== 8) goBackT(y+1,0);
			else goBackT(y,x+1);
	}
	
	static boolean check(int x, int y, int num) {
		for (int j = 0; j < 9; j++) { // 가로세로 검사
			if (board[j][x] == num) {
				return false;
			}
			if (board[y][j] == num) {
				return false;
			}
		}
		for (int ry = y / 3 * 3; ry < y / 3 * 3 + 3; ry++) { // 네모검사
			for (int rx = x / 3 * 3; rx < x / 3 * 3 + 3; rx++) {
				if (board[ry][rx] == num) {
					return false;
				}
			}
		}
		return true;
	}
	
//	static class Blank {
//		int num;
//		int x;
//		int y;
//
//		public Blank(int x, int y, int num) {
//			this.x = x;
//			this.y = y;
//			this.num = num;
//		}
//	}
}
