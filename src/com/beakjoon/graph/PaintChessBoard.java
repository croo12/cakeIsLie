package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaintChessBoard { // 클래스 이름을 Main으로 바꿔야 한다.
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] board;
	static int width;
	static int height;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		board = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = readBoard();
			}
		}
		
//		for(int[] a : board) {
//			for (int i : a) 
//				System.out.print(i+" ");
//			System.out.println();
//		}
		
		int min = 65;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int tmp = search(i,j);
				min = Math.min(min, tmp);
			}
		}
		
		System.out.println(min);
	}
	
	private static int search(int x, int y) {
		int[][] tmp = new int[8][8];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(isOutOfArray(x+i, y+j))
					tmp[i][j] = board[x+i][y+j];
				else
					return 65;
			}
		}
		
		return paintChecker(tmp);
		
	}
	
	private static int paintChecker(int[][] tmpBoard) {
		boolean isBlack = true;
		int hex = 0;
		int cnt = 0;
		for(int[] line : tmpBoard)
			for(int block : line) {
				hex++;
				if(hex> 8) {
					hex = 1;
					isBlack = !isBlack;
				}
				if(isBlack) {
					if(block != 66) cnt++;
					isBlack = false;
				}else {
					if(block != 87) cnt++;
					isBlack = true;
				}
			}
		
		return Math.min(cnt, 64-cnt);
	}
	
	private static boolean isOutOfArray(int x, int y) {
		if(x >= 0 && y >=0 && x < width && y < height)
			return true;
		else
			return false;
	}
	
	private static int readBoard() throws IOException {
		
		while(true) {
			int now = br.read();
			if(now == 'B' || now == 'W') // B : 66 // W : 87
				return now;
		}
	}
}
