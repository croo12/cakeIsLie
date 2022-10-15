package com.baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketChecker9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			if(checker(br.readLine())) 
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
	
	private static boolean checker(String s) {
		String[] ss = s.split("");
		Stack<String> stk = new Stack<>();
		
		for(String now : ss) {
			if(now.equals("(")) {
				stk.push(now);
			}else {
				if(!stk.isEmpty())
					stk.pop();
				else
					return false;
			}
		}
		
		if(stk.isEmpty()) 
			return true;
		else 
			return false;
	}
}
