package com.swea.typeB.fixWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class UserSolution {

// The below commented methods are for your reference. If you want 
// to use it, uncomment these methods.
//
	int mstrcmp(char[] a, char[] b) {
		int i;
		for (i = 0; a[i] != '\0'; i++) {
			if (a[i] != b[i])
				return a[i] - b[i];
		}
		return a[i] - b[i];
	}//equals 같으면 0 다르면 0이외
//
//	int mstrncmp(char[] a, char[] b, int len) {
//		for (int i = 0; i < len; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return 0;
//	}
//
	int mstrlen(char[] a) {
		int len = 0;

		while (a[len] != '\0')
			len++;

		return len;
	}
//
	void mstrcpy(char[] dest, char[] src) {
		int i = 0;
		while (src[i] != '\0') {
			dest[i] = src[i];
			i++;
		}
		dest[i] = src[i];
	}//단어 복사하기 dest가 복사된 배열임
	
//
//	void mstrncpy(char[] dest, char[] src, int len) {
//		for (int i = 0; i < len; i++) {
//			dest[i] = src[i];
//		}
//		dest[len] = '\0';
//	}
	
	String toString(char[] now) {
		String result = "";
		int i = 0;
		for (i = 0; now[i] != '\0'; i++) {
			result+= now[i];
		}
		return result;
	}
	
	int[] lastTime;
	Map<Integer, char[]> searchHistory;//검색기록 저장용 Key값은 시간
	Map<String , ArrayList<char[]>> db;//최종 기록 저장용
	
	void init(int n) {
		lastTime = new int[n+1];
		searchHistory = new HashMap<>();
		db = new HashMap<>();
	}
	
	boolean isCanFix(char[] last, char[] now) {
		int lastLen = mstrlen(last);
		int nowLen = mstrlen(now);
		
		boolean flag = false;
		if(lastLen+1 == nowLen) {
			for (int i = 0; i < nowLen; i++) {
				if(!flag && last[i] != now[i]) {
					flag = true;
				}else if(flag && last[i-1] != now[i])
					return false;
			}
		}else if(lastLen == nowLen) {
			for (int i = 0; i < nowLen; i++) {
				if(last[i] != now[i]) {
					if(!flag) flag = true;
					else return false;
				}
			}
		}else if(nowLen +1 == lastLen){
			for (int i = 0; i < nowLen; i++) {
				if(!flag && last[i] != now[i]) {
					flag = true;
				}else if(flag && now[i-1] != last[i])
					return false;
			}
		}else
			return false;
		
		if(flag) return true;
		else return false;
	}
	
	int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
		String now = toString(searchWord);
		
		int result = 0;
		ArrayList<char[]> correctWords = db.get(now);
		if(correctWords != null) {
			for (int i = 0; i < correctWords.size(); i++) {
				correctWord[i] = correctWords.get(i);
				result++;
			}
		}
		
		if(lastTime[mId] != 0) {
			if(lastTime[mId] + 10 < searchTimestamp); //10초 지남
			else {
				char[] last = searchHistory.get(lastTime[mId]);
				if(isCanFix(last, searchWord)) {
				}
			}
		}
		
		
		return result;
	}
	
	
}
