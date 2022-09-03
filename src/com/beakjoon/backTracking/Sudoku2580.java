package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sudoku2580 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Blank[][] board = new Blank[9][9];
		ArrayList<Blank> list = new ArrayList<>();
		
		StringTokenizer st;
		int cnt = 0;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = new Blank(Integer.parseInt(st.nextToken()));
				if(board[i][j].num == 0) list.add(board[i][j]);
			}
		}
		
		while(cnt > 0) {

		}//while
	}
	
	static class Blank{
		boolean[] pos = new boolean[9];
		int num;
		public Blank(int num) {
			this.num = num;
		}
	}
}
