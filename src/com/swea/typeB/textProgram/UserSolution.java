package com.swea.typeB.textProgram;

class UserSolution {
//	private int H;
	private int W;
	private int cursor;
	private int size;
	private String now;
	private int[][] alCnt;
	private int divs;
	private int[] div;
	private final int DIV_DIV = 1000;

	void init(int H, int W, char mStr[]) {
//		this.H = H;
		this.W = W;
		cursor = 0;
		now = "";
		int i;
		divs = H * W % DIV_DIV == 0 ? H * W / DIV_DIV : H * W / DIV_DIV + 1;
		alCnt = new int[divs][26];
		for (i = 0; mStr[i] != '\0'; i++) {
			now += mStr[i];
			alCnt[i / DIV_DIV][mStr[i] - 'a']++;
		}
		size = i;
		div = new int[divs];
		for (int j = 0; j < divs; j++) {
			div[j] = j * DIV_DIV;
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

		int nowDiv = -1;

		if (divs == 1)
			nowDiv = 0;
		else {
			int flag = -1;
			for (int i = 0; i < divs; i++) {
				if (cursor < div[i]) {
					if (flag == -1)
						flag = i - 1;
					div[i]++;
				}
			}
			if(flag == -1)
				flag = divs - 1;
			
			nowDiv = flag;
		}

		alCnt[nowDiv][mChar - 'a']++;
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
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < divs; i++) {
			if (cursor < div[i]) {
				cnt += alCnt[i][mChar - 'a'];
				min = Math.min(min, div[i]);
			}
		}

		for (int i = cursor; i < min && i < size; i++) {
			if (now.charAt(i) == mChar)
				cnt++;
		}

		return cnt;
	}
}