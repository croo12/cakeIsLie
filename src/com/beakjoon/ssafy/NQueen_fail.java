package com.beakjoon.ssafy;

import java.util.Scanner;

public class NQueen_fail { //이 코드는 총체적 쓰레기임
	
	static boolean[][] visited;
	static int N;
	
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boolean[][] board = new boolean[N][N];
				setQueen(board,i,j,1);
				visited[i][j] = true;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void setQueen(boolean[][] board, int x, int y,int n) {
		
		if(n==1 && N==1) {
			cnt = 1;
			return;
		}
		
		boolean[][] boardNow = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boardNow[i][j] = board[i][j];
			}
		}
		
		for (int i = 0; i < N ; i++) {
			boardNow[x][i] = true;
			boardNow[i][y] = true;
			
			if(x+i >= 0 && x+i < N && y+i >=0 && y+i <N)
				boardNow[x+i][y+i] = true;
			if(x-i >= 0 && x-i < N && y-i >=0 && y-i <N)
				boardNow[x-i][y-i] = true;
			if(x+i >= 0 && x+i < N && y-i >=0 && y-i <N)
				boardNow[x+i][y-i] = true;
			if(x-i >= 0 && x-i < N && y+i >=0 && y+i <N)
				boardNow[x-i][y+i] = true;
		}
		System.out.println("("+x+","+y+") 다음 "+n+"번째 퀸 놓기");
		
		for(boolean[] a : boardNow) {
			for(boolean b : a) System.out.print(b + " ");
			System.out.println();
		}
		
		System.out.println("===============================================");
		
		for (int i = x; i < N; i++) {
			if(i==x)
				for (int j = y; j < N; j++) {
					if((!boardNow[i][j]) && (!visited[i][j])) {
						if(n < N)
							setQueen(boardNow,i,j,n+1);
						else
							cnt++;
					}
				}
			else
				for (int j = 0; j < N; j++) {
					if((!boardNow[i][j]) && (!visited[i][j])) {
						if(n < N)
							setQueen(boardNow,i,j,n+1);
						else
							cnt++;
					}
				}
		}
		
	}
}
