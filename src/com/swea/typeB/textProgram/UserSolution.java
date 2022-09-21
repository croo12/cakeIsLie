package com.swea.typeB.textProgram;

class UserSolution {
	private int W;
	private int cursor;
	private int size;
	private int[][] count_stock;
	private int[] count;
	
	void init(int H, int W, char mStr[]) {
		count_stock = new int[90001][26];
		count = new int[26];
		this.W = W;
		cursor = 0;
		
		int i;
		for (i = 0; mStr[i] != '\0'; i++) {
//			count_stock[0][mStr[i] - 'a']++;
			count[mStr[i] - 'a']++;
			count_stock[i] = count.clone();
		}
		size = i;
		
		
		
//		for (int j = 0; j < size-1; j++) {
//			count_stock[j+1] = count_stock[j].clone();
//			count_stock[j+1][mStr[j] - 'a']--; 
//		}
	}

	void insert(char mChar) {
//		if (cursor == size)
//			now += mChar;
//		else if (cursor == 0)
//			now = mChar + now;
//		else
//			now = now.substring(0, cursor) + mChar + now.substring(cursor);
		
		size++;
		int c = mChar - 'a';
		
		count[c]++;
		
		
		System.arraycopy(count_stock, cursor, count_stock, cursor+1, size - cursor - 1);
		for (int i = size-1; i > cursor; i--) {
//			count_stock[i] = count_stock[i-1];
			count_stock[i][c]++;
		}
		
		if(cursor == 0)
			count_stock[cursor] = new int[26];
		else
			count_stock[cursor] = count_stock[cursor-1].clone();
		
		count_stock[cursor][c]++;
		
//		count_stock[cursor] = count_stock[cursor].clone();
//		count_stock[cursor][mChar-'a']++;
//		for (int i = cursor - 1; i >= 0; i--) {
//			count_stock[i][mChar-'a']++;
//		}
		
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
		else if(cursor == 0) {
			for (int i = 0; i < 26; i++) {
				if(count_stock[cursor][i] == 1) {
					return (char)(i+'a');
				}
			}
		}
		else {
			for (int i = 0; i < 26; i++) {
				if(count_stock[cursor][i] != count_stock[cursor-1][i]) {
					return (char)(i+'a');
				}
			}
		}
		return '\0';
	}

	int countCharacter(char mChar) {
		if(cursor == 0) return count[mChar - 'a'];

		return count[mChar-'a'] - count_stock[cursor - 1][mChar-'a'];
	}
}