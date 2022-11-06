package com.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS9251 {
	public static void main(String[] args) {
		try {
			new LCS9251().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int ans = 0;
	boolean[] check = new boolean[26];
	
	char[] s1;
	char[] s2; 
	
	int len1;
	int len2;
	
	void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine().toCharArray();
		s2 = br.readLine().toCharArray();
		//완전탐색? 1000 * 1000 
		//이거 안됨?
		
		len1 = s1.length;
		len2 = s2.length;
		
		dfs(0, 0, 0);
		
		System.out.println(ans);
	}
	
	void dfs(int s1Idx, int s2Idx, int cnt) {

		char now = s1[s1Idx];
		
		for (int i = s2Idx; i < len2; i++) {
			
		}
	}
}
