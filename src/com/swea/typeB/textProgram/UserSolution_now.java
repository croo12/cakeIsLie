package com.swea.typeB.textProgram;

import java.util.Arrays;

class UserSolution_now {
	private int W;
	private int cursor;
	private int size;
	private int[][] count_stock;
	private char[] now;
	
	void init(int H, int W, char mStr[]) {
		count_stock = new int[H][26];
		now = new char[90001];
		this.W = W;
		cursor = 0;
		
		int i;
		char c;
		for (i = 0; (c = mStr[i]) != '\0'; i++) {
			now[i] = c;
			count_stock[i/W][c - 'a']++;
		}
		size = i;
	}

	void insert(char mChar) {
		
		System.arraycopy(now, cursor, now, cursor+1, size - cursor);
		now[cursor] = mChar;
		count_stock[cursor/W][mChar - 'a']++;
		
		size++;
		
		
		
		for (int i = (cursor/W + 1) * W; i < size; i+=W) {
			int c = now[i] - 'a';
			int h = i/W;
			count_stock[h][c]--;
			if(h+1 <= size/W)
				count_stock[h+1][c]++;
		}
		
		cursor++;
	}

	char moveCursor(int mRow, int mCol) {
		int y = mRow - 1;
		int x = mCol - 1;
		cursor = W * y + x;
		

		if (cursor >= size) {
			cursor = size;
			return '$';
		}
		else {
			return now[cursor];
		}
	}

	int countCharacter(char mChar) {
		if(cursor == size) return 0;
		
		System.out.printf("현재 커서의 위치 %d\n",cursor);
		for(int i = 0; i < size; i++)
			System.out.print( now[i] + " ");
		System.out.println();
		
		int c = mChar - 'a';
		int lastRow = size/W;
		int cnt = 0;
		for (int i = cursor/W; i <= lastRow; i++) {
			cnt += count_stock[i][c];
		}
		
		for (int i = cursor/W * W; i < cursor; i++) {
			if(now[i] == mChar)
				cnt--;
		}
		
		return cnt;
	}
}