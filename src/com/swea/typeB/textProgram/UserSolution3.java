package com.swea.typeB.textProgram;

class UserSolution3 {
//	private int H;
	private int W;
	private int cursor;
	private int size;
	private int[][] count_stock;

	void init(int H, int W, char mStr[]) {
		count_stock = new int[90001][26];
//		this.H = H;
		this.W = W;
		cursor = 0;
		
		int i = 0;
		while (true) {
			if(mStr[i] == '\0') break;
			count_stock[0][mStr[i] - 'a']++;
			i++;
		}
		
		size = i;
		
		for (int j = 0; j < size-1; j++) {
			for (int k = 0; k < 26; k++) {
				count_stock[j+1][k] = k != mStr[j] - 'a' ? count_stock[j][k] : count_stock[j][k] - 1;
			}
		}

//		System.out.println(divs);
	}

	void insert(char mChar) {
//		if (cursor == size)
//			now += mChar;
//		else if (cursor == 0)
//			now = mChar + now;
//		else
//			now = now.substring(0, cursor) + mChar + now.substring(cursor);
//		for (int i = size-1; i > cursor; i--) {
//			count_stock[i] = count_stock[i-1];
//		}
		
		System.arraycopy(count_stock, cursor, count_stock, cursor+1, size - cursor);
		size++;
		count_stock[cursor] = count_stock[cursor].clone();
		count_stock[cursor][mChar-'a']++;
		
		for (int i = cursor - 1; i >= 0; i--) {
			count_stock[i][mChar-'a']++;
		}
		
		cursor++;
		
		

//		System.out.println(now);
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
			for (int i = 0; i < 26; i++) {
				if(count_stock[cursor][i] != count_stock[cursor+1][i]) {
					return (char)(i+'a');
				}
			}
			return '\0';
		}
	}

	int countCharacter(char mChar) {
		if(cursor == size) return 0;

		return count_stock[cursor][mChar-'a'];
	}
}