package com.swea.typeB.textProgram;

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
		
		for (int i = cursor/W + 1; i <= size/W; i++) {
			int c = now[i*W] - 'a';
			count_stock[i-1][c]--;
			count_stock[i][c]++;
		}
		
		size++;
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
//		System.out.printf("현재 커서의 위치 %d\n현재 사이즈 %d\n",cursor, size);
//		for(int i = 0; i < size; i++)
//			System.out.print( now[i] + " ");
//		System.out.println();
		
		int c = mChar - 'a';
		int end = (size-1)/W;
		int cnt = 0;
		for (int i = cursor/W + 1; i <= end; i++) {
			cnt += count_stock[i][c];
		}
		
		int last = Math.min((cursor/W + 1) * W, size);
		for (int i = cursor; i < last; i++) {
			if(now[i] == mChar)
				cnt++;
		}
		
		return cnt;
	}
}