package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Editor1406_LinkedList {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int N = Integer.parseInt(br.readLine());
		
		Node left = new Node('\0', null);
		//현재 커서의 왼쪽 값을 가리킴
		Node now = left;
		
		for (int i = 0; i < len; i++) {
			now.right = new Node(s.charAt(i), now);
			now = now.right;
		}

		now.right = new Node('\0', now);
		
		while(N-- > 0) {
			String[] ss = br.readLine().split(" ");

			switch(ss[0]) {
			case "L":
				if(now.val != '\0')
					now = now.left;
				break;
			
			case "D":
				if(now.right.val != '\0')
					now = now.right;
				break;
			
			case "B":
				if(now.val != '\0') {
					now.left.right = now.right;
					now.right.left = now.left;
					now = now.left;
				}
				break;
				
			case "P":
				Node tmp = now.right;
				now.right = new Node(ss[1].charAt(0), now);
				now = now.right;
				now.right = tmp;
				now.right.left = now;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		now = left.right;
		while(now.val != '\0') {
			sb.append(now.val);
			now = now.right;
		}
		
		System.out.println(sb);
	}
	
	static class Node{
		Node left;
		Node right;
		char val;
		Node(char val, Node left){
			this.val = val;
			this.left = left;
		}
	}
}
