package com.elses.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String S;
	static StringBuilder index = new StringBuilder();
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			index.append("IO");
		}
		index.append("I");
		
		br.readLine();
		S = br.readLine();	
		cnt = 1;
		search(0);
		int result = cnt-1;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
	
	private static void search(int last) {
		int next = S.indexOf(index.toString(),last);
		if(next == -1) return;
		cnt++;
		search(next+1);
	}
}
