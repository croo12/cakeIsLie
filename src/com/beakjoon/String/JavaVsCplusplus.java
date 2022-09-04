package com.beakjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaVsCplusplus {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int isJava = 0; // 0 모름 , 1 자바, 2 C++
		boolean isError = false; //
		boolean underbarFlag = false; 
		String sentence = br.readLine();
		int length = sentence.length();
		int cnt = 0;
		
		char now;
		while(cnt < length) {
			now = sentence.charAt(cnt);
			if(now >= 65 && now <= 90) { //대문자가 들어온다
				if(isJava == 2 || cnt == 0) {
					isError = true;
					break;
				}
				isJava = 1;
				sb.append('_').append((char) (now+32));
				
			}else if(now == '_') { //언더바가 들어온다
				if(isJava == 1 || cnt == 0 || underbarFlag || cnt == length - 1) {
					isError = true;
					break;
				}
				isJava = 2;
				underbarFlag = true;
				
			}else if(now >= 97 || now <= 122) { //소문자가 들어온다
				if(underbarFlag) {
					sb.append((char)(now-32));
					underbarFlag = false;
				}else {
					sb.append(now);					
				}
			}
			
			cnt++;
		}
		
		if(isError) System.out.println("Error!");
		else System.out.println(sb);
	}
}
