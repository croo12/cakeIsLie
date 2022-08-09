package com.beakjoon.ssafy;

import java.util.Scanner;

public class PaintChessBoard_fail { // 클래스 이름을 Main으로 바꿔야 한다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		String[][] board = new String[r][c];
		int min = 65;
		
		for (int i = 0; i < r; i++) {
			String s = sc.next();
			String[] ss = s.split("");
			for (int j = 0; j < c; j++) {
				board[i][j] = ss[j];
			}
		}
		
		for (int i = 0; i < board.length-7; i++) {
			for (int j = 0; j < board.length-7; j++) {
				String[][] chess = new String[8][8];
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						chess[k][l] = board[i+k][j+l];
					}
				}
				int tmp = check_sum(chess);
				if( tmp < min)
					min = tmp;
			}
		}
		System.out.println(min);
		sc.close();
	}
	
	public static int check_sum(String[][] chess) {
		int sum = 0;
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
//				System.out.print(chess[i][j]);
				if(chess[i][j].equals("B") && (i+j)%2 == 0) {
					sum++;
				}
				if(chess[i][j].equals("W") && (i+j)%2 == 1) {
					sum++;
				}
			}
//			System.out.println();
		}
		
		if(sum <= 32)
			return sum;
		else
			return 64 - sum;
	}
	

}
