package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretEmail2999 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cs = br.readLine().toCharArray();
		
		int n = cs.length;
		int c = 0;
		
		int cnt = 0;
		while(++cnt < n) {
			if(cs.length%cnt == 0) {
				n = cs.length/cnt;
				c = cnt;
			}
		}
		
//		System.out.println(c + " " + n);
		
		char[][] password = new char[c][n];
		
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < c; j++) {
				password[j][i] = cs[cnt++];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(password[i][j]);
			}
		}
		System.out.println(sb);
	}
}
