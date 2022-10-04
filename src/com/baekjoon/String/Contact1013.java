package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact1013 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			//이거 정규표현식 문제네
			
			String one = br.readLine();
			
			if(!one.matches("(100+1+|01)+")) {
				sb.append("NO").append('\n');
			}else {
				sb.append("YES").append('\n');
			}
		}
		
		System.out.print(sb);
	}
}
