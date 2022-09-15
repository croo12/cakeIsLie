package com.swea.typeB.textProgram;

class UserSolution
{
	int H;
	int W;
	int cursor;
	int size;
	String now;
	int[] alCnt;
	
	void init(int H, int W, char mStr[])
	{
		this.H = H;
		this.W = W;
		cursor = 0;
		now = "";
		int i;
		alCnt = new int[26];
		for (i = 0; mStr[i] != '\0'; i++) {
			now += mStr[i];
			alCnt[mStr[i] - 'a']++;
		}
		size = i;
		
//		System.out.println(now);
	}
	
	void insert(char mChar)
	{
		if(cursor == size)
			now += mChar;
		else if(cursor == 0)
			now = mChar + now;
		else
			now = now.substring(0, cursor) + mChar + now.substring(cursor);
		size++;
		cursor++;
		alCnt[mChar-'a']++;
		
//		System.out.println(now);
	}

	char moveCursor(int mRow, int mCol)
	{
		int y = mRow -1;
		int x = mCol -1;
		cursor = W*y + x;
		
//		System.out.println(now);
		
		if(cursor >= size) {
			cursor = size;
			return '$';
		}else
			return now.charAt(cursor);
	}

	int countCharacter(char mChar)
	{
		int cnt = 0;
		
		if(cursor > size/2)
			for (int i = cursor; i < size; i++) {
				if(now.charAt(i) == mChar)
					cnt++;
			}
		else {
			for (int i = cursor - 1; i >= 0; i--) {
				if(now.charAt(i) == mChar)
					cnt++;
			}
			
			cnt = alCnt[mChar - 'a'] - cnt;
		}
		
//		System.out.println(now);
		
		return cnt;
	}
}