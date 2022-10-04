package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhiteBlank1100 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = 0;
		boolean isWhite = true;
		//이거 걍 구현문제 아닌가
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				int now = br.read();
				if(((j%2 == 0 && isWhite) || (j%2 == 1 && !isWhite)) && now == 'F') {					
					cnt++;
				}
			}
			isWhite = !isWhite;
			br.readLine();
		}
		
		System.out.println(cnt);
	}
}
