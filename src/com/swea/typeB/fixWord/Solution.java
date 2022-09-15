package com.swea.typeB.fixWord;

import java.util.Scanner;

class Solution {
	
	private static int n, m;
	
	private final static UserSolution usersolution = new UserSolution();
	
	private static char[][] words = new char[4000][11];
	
	private static int mstrcmp(char[] a, char[] b)
	{
		int i;
		for (i = 0; a[i] != '\0'; i++)
		{
			if (a[i] != b[i])
				return a[i] - b[i];
		}
		return a[i] - b[i];
	}//char 배열 두개를 비교해서 int를 반환함
	//같다 0반환
	//다르다 그 외 반환

	private static void String2Char(String s, char[] b) {
		int n = s.length();
		for (int i = 0; i < n; ++i) {
			b[i] = s.charAt(i);
		}
		b[n] = '\0';
	}//char배열과 String을 넣으면 넣은 String을 char배열에 넣어줌 
	
	private static void inputWords(int wordCnt, Scanner sc) {
		
		for (int i = 0; i < wordCnt; ++i) {
			String2Char(sc.next(), words[i]);	
		}
	}//매개변수로 int wordCnt를 받아서
	//words[]에다가 입력한 단어를 wordCnt만큼 넣음
	//words는 가로 길이가 11이고 4000줄짜리 배열임
	
	private static boolean run(int m, Scanner sc) {
		
		boolean accepted = true;
		char[][] correctWord = new char[5][11];
		char[][] answerWord = new char[5][11];
		
		while(m-- > 0) {//m번 시행
			
			int id, timestamp, correctWordN, answerWordN;
			int wordIdx;
			
			id = sc.nextInt(); // 멤버 아이디
			timestamp = sc.nextInt(); // 시간
			wordIdx = sc.nextInt(); // 단어 idx
			
			correctWordN = usersolution.search(id, timestamp, words[wordIdx], correctWord);
			// 내가 만든 search. 교정된 단어의 개수를 리턴한다
			// 교정된 단어가 있다면 correctWord에 넣어서 돌려보냄
			
			answerWordN = sc.nextInt(); // 내가 맞았다면 리턴되었어야 하는 수
			
			for (int i = 0; i < answerWordN; ++i) {
				String2Char(sc.next(), answerWord[i]);
			}//내가 맞았다면 correctWord에 넣었어야 하는 단어
			
			if (correctWordN != answerWordN) { //리턴 개수가 틀려용				
				accepted = false; // 너 틀림
			} else { // 리턴 개수는 맞음
				for (int i = 0; i < answerWordN; ++i) { // 리턴된 단어도 비교해보자
					boolean isExist = false;
					
					for (int j = 0; j < correctWordN ; ++j) {
						if (mstrcmp(answerWord[i], correctWord[j]) == 0) { //비-교
							isExist = true;
						}
					}
					
					if (!isExist) {
						accepted = false;
					}
				}
			}
		}
		
		return accepted; // 야 성공이다!
	}
	
	public static void main(String[] args) throws Exception {
		
		int test, T;
		int wordCnt;
		
		// System.setIn(new java.io.FileInputStream("sample_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt(); // 테스트 케이스의 수 반환
		
		for (test = 1 ; test <= T ; ++test) {
			
			wordCnt = sc.nextInt();// 단어의 개수
			
			inputWords(wordCnt, sc); // 를 배열에 넣음 (char배열에)
			
			n = sc.nextInt(); // 사람 수
			m = sc.nextInt(); // 순번이 몇개임
			
			usersolution.init(n); //내가 만들어야하는 이닛
			
			if (run(m, sc)) { //run!!
				System.out.println("#" + test + " 100");
			} else {
				System.out.println("#" + test + " 0");
			}
		}
	}
}