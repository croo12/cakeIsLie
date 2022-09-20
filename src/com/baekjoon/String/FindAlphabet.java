package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cs = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			boolean flag = false;
			for (int j = 0; j < cs.length; j++) {
				if(i == cs[j] - 'a') {
					sb.append(j);
					flag = true;
					break;
				}
			}
			if(!flag) { sb.append(-1); }
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
