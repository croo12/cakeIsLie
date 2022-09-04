package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sudoku2580_FAIL {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Blank[][] board = new Blank[9][9];
		ArrayList<Blank> zeros = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = new Blank(j, i, Integer.parseInt(st.nextToken()));
				if (board[i][j].num == 0)
					zeros.add(board[i][j]);
			}
		}
		
		Blank now;
		int tmp;
		while (zeros.size() > 0) {
			tmp = 0;
			for (int i = zeros.size()-1; i >= 0; i--) {
				now = zeros.get(i);
				for (int j = 0; j < 9; j++) {
					if(board[j][now.x].num != 0 && !now.posNum[board[j][now.x].num - 1]) {
						now.posNum[board[j][now.x].num - 1] = true;
						now.pos--;
					}
					if(board[now.y][j].num != 0 && !now.posNum[board[now.y][j].num - 1]) {
						now.posNum[board[now.y][j].num - 1] = true;
						now.pos--;
					}
				}
				for (int ry = now.y/3 * 3; ry < 3; ry++) {
					for (int rx = now.x/3 * 3; rx < 3; rx++) {
						if(board[ry][rx].num != 0 && !now.posNum[board[ry][rx].num - 1]) {
							now.posNum[board[ry][rx].num - 1] = true;
							now.pos--;
						}
					}
				}
				if(now.pos == 1) {
					for (int j = 0; j < 9; j++) {
						if(!now.posNum[j]) {
							now.num = j + 1;
							zeros.remove(i);
							tmp++;
						}
					}
				}
			}
			if(tmp == 0) {
				doBT(0);
			}
		} // while
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j].num).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	private static void doBT(int depth) {
		
	}

	static class Blank {
		boolean[] posNum;
		int pos;
		int num;
		int x;
		int y;

		public Blank(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
			posNum = new boolean[9];
			pos = 9;
		}
	}
}
