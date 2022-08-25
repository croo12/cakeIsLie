package com.elses.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test0825 {

	static char[][] board;
	static int n, cnt;

	static boolean chk(int x, int y) {
		// 가로 검사
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (y + i < n && board[x][y + i] == 'o')
				cnt++;
		}
		if (cnt == 5)
			return true;
		// 세로 검사
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (x + i < n && board[x + i][y] == 'o')
				cnt++;
		}
		if (cnt == 5)
			return true;
		// 오른쪽 위로 향하는 대각선
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (x - i >= 0 && y + i < n && board[x - i][y + i] == 'o')
				cnt++;
		}
		if (cnt == 5)
			return true;
		// 오른쪽 아래로 향하는 대각선
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (x + i < n && y + i < n && board[x + i][y + i] == 'o')
				cnt++;
		}
		if (cnt == 5)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			board = new char[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < 5; j++) {
					board[i][j] = str.charAt(j);
				}
			}
			
			for(char[] cc : board) {
				for(char c : cc) System.out.print(c);
				System.out.println();
			}

			String ans = "NO";
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 'o') {
						chk(i, j);
					}
					if (chk(i, j)) {
						ans = "YES";
						break loop;
					}
				}
			}

			System.out.printf("#%d %s\n", t, ans);
		}
	}
}
