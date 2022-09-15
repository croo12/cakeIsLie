package com.swea.typeB.fixWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class UserSolution {

// The below commented methods are for your reference. If you want 
// to use it, uncomment these methods.
//
//	int mstrcmp(char[] a, char[] b) {
//		int i;
//		for (i = 0; a[i] != '\0'; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return a[i] - b[i];
//	}// equals 같으면 0 다르면 0이외
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
//	void mstrcpy(char[] dest, char[] src) {
//		int i = 0;
//		while (src[i] != '\0') {
//			dest[i] = src[i];
//			i++;
//		}
//		dest[i] = src[i];
//	}// 단어 복사하기 dest가 복사된 배열임

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
			result += now[i];
		}
		return result;
	}

	int N;
	int[] lastTime;
	Map<Integer, char[]> searchHistory;// 검색기록 저장용 Key값은 시간
	Map<String, ArrayList<char[]>> db;// 최종 기록 저장용
	Map<String, int[]> tmp; // 중간 저장용 (3개 쌓이면 db로감)

	void init(int n) {
		N = n;
		lastTime = new int[N + 1];
		searchHistory = new HashMap<>();
		db = new HashMap<>();
		tmp = new HashMap<>();
	}

	boolean isCanFix(char[] last, char[] now) {
		int lastLen = mstrlen(last);
		int nowLen = mstrlen(now);

		boolean flag = false;
		if (lastLen + 1 == nowLen) {
			for (int i = 0; now[i] != '\0'; i++) {
				if (!flag && last[i] != now[i]) {
					flag = true;
				} else if (flag && last[i - 1] != now[i])
					return false;
			}
		} else if (lastLen == nowLen) {
			for (int i = 0; now[i] != '\0'; i++) {
				if (last[i] != now[i]) {
					if (!flag)
						flag = true;
					else
						return false;
				}
			}
		} else if (nowLen + 1 == lastLen) {
			for (int i = 0; last[i] != '\0'; i++) {
				if (!flag && last[i] != now[i]) {
					flag = true;
				} else if (flag && now[i - 1] != last[i])
					return false;
			}
		} else
			return false;

		if (flag)
			return true;
		else
			return false;
	}

	int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
		String now = toString(searchWord);
		int result = 0;
		ArrayList<char[]> correctWords = db.get(now); //db에 저장된 교정 낱말들 소환
		if (correctWords != null) {
			for (int i = 0; i < correctWords.size(); i++) {
				correctWord[i] = correctWords.get(i);
				result++;
			}
		}else {
			correctWords = new ArrayList<>();
			db.put(now, correctWords);
		}

		if (lastTime[mId] != 0) {
			if (lastTime[mId] + 10 < searchTimestamp) {} // 10초 지남
			else {
				char[] last = searchHistory.get(lastTime[mId]);
				String lastString = toString(last);
				if (isCanFix(last, searchWord)) { //에러의 범주라면
					String key = lastString + " " + now;
					int[] checker = tmp.get(key);
					if(checker == null) { 
						checker = new int[N+1];
						checker[0] = 1;
						checker[mId] = 1;
						tmp.put(key, checker);
					}else if(checker[0] != -1) {
						if(checker[mId] == 0) {
							checker[0]++;
							checker[mId] = 1;
							if(checker[0] >= 3) { //3개의 표본이 모임
								checker[0] = -1;
								tmp.put(key, checker);
								ArrayList<char[]> database = db.get(lastString);
								if(database == null)
									database = new ArrayList<char[]>();
								database.add(searchWord);
								db.put(lastString, database);
							}else {
								tmp.put(key, checker);
							}
						}
					}
				}
			}
		}
		
		lastTime[mId] = searchTimestamp;
		searchHistory.put(searchTimestamp, searchWord);

		return result;
	}

}
