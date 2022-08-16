package com.beakjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack10828 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			switch (st.nextToken()) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					try {
						System.out.println(stack.pop());
					} catch (EmptyStackException e) {
						System.out.println(-1);
					}
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if(stack.isEmpty()) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					break;
				case "top":
					try {
						System.out.println(stack.peek());
					} catch (EmptyStackException e) {
						System.out.println(-1);
					}
				default:
					break;
			}
		}
	}
}
