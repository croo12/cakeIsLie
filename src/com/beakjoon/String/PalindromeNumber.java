package com.beakjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] now;
		while(true) {
			now = br.readLine().toCharArray();
			if(now[0] == '0') {
				System.out.print(sb);
				return;
			}
			
			String result = "yes";
			for (int i = 0; i < now.length/2; i++) {
				if(now[i] != now[now.length- 1 - i]) {
					result = "no";
					break;
				}
			}
			sb.append(result).append('\n');
		}
	}
}
