package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartOfString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		
		int len = S.length();
		int PLen = P.length();
		
		int[] table = makeTable(P);
		
		int idx = 0;
		for (int i = 0; i < len; i++) {
			while(idx > 0 && S.charAt(i) != P.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(S.charAt(i) == P.charAt(idx)) {
				if(idx == PLen - 1) {
					System.out.println(1);
					return;
				}else {
					idx+= 1;
				}
			}
		}
		
		System.out.println(0);
	}
	
	static int[] makeTable(String S) {
		int n = S.length();
		int[] table = new int[n];
		
		int idx = 0;
		for (int i = 1; i < n; i++) {
			while(idx > 0 && S.charAt(i) != S.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(S.charAt(i) == S.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		
		return table;
	}
}
