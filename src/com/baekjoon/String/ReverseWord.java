package com.baekjoon.String;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		boolean isTag = false;
		int now;
		int cnt = 0;
		while (cnt < c.length) {
			now = c[cnt++];
			if (isTag) {
				sb.append((char) now);
				if (now == '>')
					isTag = false;
			} else {
				if (now == ' ') {
					while (!stk.isEmpty())
						sb.append(stk.pop());
					sb.append((char) now);
				} else if (now == '<') {
					while (!stk.isEmpty())
						sb.append(stk.pop());
					isTag = true;
					sb.append((char) now);
				} else
					stk.push((char) now);
			}
			
			if(cnt == c.length && !isTag) {
				while (!stk.isEmpty())
					sb.append(stk.pop());
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
