package com.swea.typeB.textProgram;

class UserSolution2 {
//	private int H;
	private int W;
	private int cursor;
	private int size;
	private String now;
	private int[] count = new int[26];
	private int[][] count_stock = new int[90001][26];

	void init(int H, int W, char mStr[]) {
//		this.H = H;
		this.W = W;
		cursor = 0;
		now = "";
		
		int i;
		for (i = 0; mStr[i] != '\0'; i++) {
			now += mStr[i];
			count[mStr[i] - 'a']++;
		}
		
		size = i;
		
		count_stock[0] = count;
		for (int j = 0; j < size-1; j++) {
			for (int k = 0; k < 26; k++) {
				count_stock[j+1][k] = k != now.charAt(j) - 'a' ? count_stock[j][k] : count_stock[j][k] - 1;
			}
		}

//		System.out.println(divs);
	}

	void insert(char mChar) {
		if (cursor == size)
			now += mChar;
		else if (cursor == 0)
			now = mChar + now;
		else
			now = now.substring(0, cursor) + mChar + now.substring(cursor);
		
		size++;
		
		for (int i = size-1; i > cursor; i--) {
			count_stock[i] = count_stock[i-1];
		}
		for (int i = cursor; i >= 0; i--) {
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
		} else
			return now.charAt(cursor);
	}

	int countCharacter(char mChar) {
		if(cursor == size) return 0;

		return count_stock[cursor][mChar-'a'];
	}
}