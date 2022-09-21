package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThrowStone3025_Fail {
	static Pair[][] board;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new Pair[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				if(s.charAt(j) == 'X')
					board[i][j] = new Pair(i,j,true);
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		int now;
		int h;
		while(N-- > 0) {
			now = Integer.parseInt(br.readLine()) - 1;
			h = 0;
			while(true) {
				while(h != R && board[h][now] == null)
					h++;
				
				if(h == R) {
					board[h-1][now] = new Pair(h-1,now,false);
					break;
				}
				
				int stone = board[h][now].nowGo();
				if(stone == 1) {
					now--;
				}else if(stone == 2)
					now++;
				else {
//					System.out.printf("h == %d , now == %d",h-1,now);
					board[h-1][now] = new Pair(h-1,now,false);
					break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Pair pr;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				pr = board[i][j];
				if(pr == null)
					sb.append('.');
				else
					if(pr.isWall)
						sb.append('X');
					else
						sb.append('O');
				
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	static class Pair{
		int r;
		int c;
		int go; //0 : stop, 1: left, 2: right //-1 undefine;
		boolean isWall;
		Pair(int r, int c, boolean isWall) {
			this.r = r;
			this.c = c;
			this.isWall = isWall;
			if(!isWall) {
				go = -1;
				if(c != 0) {
					if(board[r][c-1] != null && board[r][c-1].go != 0) board[r][c-1].go = -1;
					if(r != 0 && board[r-1][c-1] != null && board[r-1][c-1].go != 0) board[r-1][c-1].go = -1;
				}
				if(c != C-1) {
					if(board[r][c+1] != null && board[r][c+1].go != 0) board[r][c+1].go = -1;
					if(r != 0 && board[r-1][c+1] != null && board[r-1][c+1].go != 0) board[r-1][c+1].go = -1;
				}
			}else {
				go = 0;
			}
		}
		
		int nowGo() {
			if(go != -1)
				return go;
			
			if(c != 0 && board[r][c-1] == null && board[r-1][c-1] == null)
				go=1;
			else if(c != C-1 && board[r][c+1] == null && board[r-1][c+1] == null)
				go=2;
			else
				go=0;
			
			return go;
		}
	}
}
