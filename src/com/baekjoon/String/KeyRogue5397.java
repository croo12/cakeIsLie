package com.baekjoon.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class KeyRogue5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> std = new Stack<>();
		Stack<Character> tmp = new Stack<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] keys = br.readLine().toCharArray();
			
			for (int i = 0; i < keys.length; i++) {
				char now = keys[i];
				if (now == '<') {
					if(!std.isEmpty()) {
						tmp.push(std.pop());
					}
				}
				else if (now == '>') {
					if(!tmp.isEmpty()) {
						std.push(tmp.pop());
					}
				}
				else if (now == '-') {
					if(!std.isEmpty()) {
						std.pop();
					}
				}else if(now == '\r'){
					break;
				}else {
					std.push(now);
				}
				
				
			}
			while(!std.isEmpty()) {
				tmp.push(std.pop());
			}
			while(!tmp.isEmpty()) {
				bw.write(tmp.pop());
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
