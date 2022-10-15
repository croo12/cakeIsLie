package com.baekjoon.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Editor1406_LinkedList {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Character> left = new ArrayDeque<>();
		ArrayDeque<Character> right = new ArrayDeque<>();

		for (int i = 0; i < len; i++) {
			left.addLast(s.charAt(i));
		}
		
		while(N-- > 0) {
			String[] ss = br.readLine().split(" ");
			switch(ss[0]) {
			case "L":
				if(!left.isEmpty())
					right.addLast(left.pollLast());
				break;
			
			case "D":
				if(!right.isEmpty())
					left.addLast(right.pollLast());
				break;
			
			case "B":
				if(!left.isEmpty())
					left.pollLast();
				break;
				
			case "P":
				left.addLast(ss[1].charAt(0));
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty())
			sb.append(left.pollFirst());
		
		while(!right.isEmpty())
			sb.append(right.pollLast());
		
		System.out.println(sb);
	}
}
