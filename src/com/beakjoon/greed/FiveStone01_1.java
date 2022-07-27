//package com.beakjoon.greed;
//
//import java.util.Scanner;
//
//public class FiveStone01_1 {
//
//	static int winner=0;
//
//	public static void main(String[] args) {
//		Scanner sc =new Scanner(System.in);
//		int[][] board = new int[19][19];
//		
//		for (int i = 0; i < 19; i++) {
//			for (int j = 0; j < 19; j++) {
//				board[i][j] = sc.nextInt();
//			}
//		}
//		int[] pair = win_checker(board);
//		if(pair == null) {
//			System.out.println(0);
//		}else {
//			System.out.println(winner);
//			System.out.println((pair[0]+1) + " " + (pair[1]+1));
//		}
//		
//		sc.close();
//	}
//	
//	public static int[] win_checker(int[][] board) {
//		
//		
//		for (int i = 0; i < 19; i++) {
//			for (int j = 0; j < 19; j++) {
//				if(board[i][j] != 0) {
//					moving(board,i,j,board[i][j]);
//				}	
//			}
//		}
//		return null;
//	}
//	
//	public static int moving(int[][] board, int i,int j, int color) {
//		int[] pair = {19,19};
//		
//		int[] x = new int[5];
//		int[] y = new int[5];
//		
//		int[] dx = {0,1,1,-1};
//		int[] dy = {1,0,1,1}; //아래, 오른쪽, 남동, 남서
//		
//		return 0;
//	}
//}
