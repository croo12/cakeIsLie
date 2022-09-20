package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sudoku2580 {
	static Blank[][] board;
	static ArrayList<Blank> zeros;
	static int left;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new Blank[9][9];
		zeros = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = new Blank(j, i, Integer.parseInt(st.nextToken()));
				if (board[i][j].num == 0) {
					left++;
					zeros.add(board[i][j]);
				}
			}
		}

		goBackT(0);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j].num).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	static boolean[] vis;

	static void goBackT(int depth) {
		Blank now;
		int tmpLeft = 0;
		while (true) {
			
			boolean flag = false;
			if(left == 0) return;
			
			for (int i = 0; i < zeros.size(); i++) {
				
				now = zeros.get(i);
				if(now.num != 0) continue;
				
				int cnt = checkPos(now); // 가능한 경우의 수 탐색
				
				if(cnt == 0) { // 이 빈칸에 넣을 수 있는 수는 없다. == 지금 상황은 틀렸다 빠꾸하기 
					left += tmpLeft;
					for (int j = 0; j < zeros.size(); j++) {
						now = zeros.get(j);
						if(now.depth == depth) {
							now.depth = -1;
							now.num = 0;
						}
					}
					return;
				} 
				
				if(cnt == 1) { // 이 빈칸에 넣을 수 있는  수는 하나다.
					//빈칸채우기 depth넣기
					for (int j = 0; j < 9; j++) {
						if(!vis[j]) {
							now.num = j+1;
							now.depth = depth;
							left--;
							tmpLeft++;
							flag = true;
						}
					}
				}
			} // for 탈출
			
			if(!flag) { //0인 빈칸이 전부 경우의 수가 2개 이상임
				break;
			}
		}
		
		for (int i = 0; i < zeros.size(); i++) {
			now = zeros.get(i);
			if(now.num != 0) continue;
			checkPos(now);
			
			for (int j = 0; j < 9; j++) {
				if(!vis[j]) {
					now.num = j+1;
					now.depth = depth;
					goBackT(depth+1);
					if(left == 0) return;
					now.num = 0;
					now.depth = -1;
				}
			}
		}
		
		for (int j = 0; j < zeros.size(); j++) {
			now = zeros.get(j);
			if(now.depth == depth) {
				now.depth = -1;
				now.num = 0;
			}
		}
	}
	
	private static int checkPos(Blank now) {
		int cnt = 9; // 가능한 숫자 수
		vis = new boolean[9]; // 가능한 숫자 체크 배열
		for (int j = 0; j < 9; j++) { // 가로세로 검사
			if (board[j][now.x].num != 0 && !vis[board[j][now.x].num - 1]) {
				vis[board[j][now.x].num - 1] = true;
				cnt--;
			}
			if (board[now.y][j].num != 0 && !vis[board[now.y][j].num - 1]) {
				vis[board[now.y][j].num - 1] = true;
				cnt--;
			}
		}
		for (int ry = now.y / 3 * 3; ry < now.y / 3 * 3 + 3; ry++) { // 네모검사
			for (int rx = now.x / 3 * 3; rx < now.x / 3 * 3 + 3; rx++) {
				if (board[ry][rx].num != 0 && !vis[board[ry][rx].num - 1]) {
					vis[board[ry][rx].num - 1] = true;
					cnt--;
				}
			}
		}
		
		return cnt;
	}

	static class Blank {
		int num;
		int x;
		int y;
		int depth;

		public Blank(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.depth = -1;
		}
	}
}
