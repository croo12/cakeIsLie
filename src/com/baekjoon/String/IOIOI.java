package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T; //연속해서 성공해야하는 횟수
	static int MAX; //받는 char의 수
	static int cnt = 0; // 정답
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine()) * 2 + 1;
		MAX = Integer.parseInt(br.readLine());
		
		read();
		
		System.out.println(cnt);
	}
	
	private static void read() throws IOException {
		boolean IOFlag = true; //I = true // O = false
		int streak = 0;
		
		while(MAX-- > 0) {
			int now = br.read(); //한글자 char로 읽어옴 -> ascii code로 리턴함
			
			if(IOFlag) { // I를 받을 차례
				if(now == 'I') {
					streak++;
					IOFlag = false; //O를 받을 차례로 바꾼다.
				}else {
					streak = 0;
					IOFlag = true;
				}
			}else { // O를 받을 차례
				if(now == 'O') {
					streak++;
					IOFlag = true; //I를 받을 차례로 바꾼다.
				}else {
					streak = 1;
					IOFlag = false;
				}
			
			}
			
			if(streak == T) {
				streak -= 2;
				cnt++;
			}
		}
	}
}
