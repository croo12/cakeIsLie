package com.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightBogNumber17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stk = new Stack<>();
		Stack<Integer> idxStk = new Stack<>();
		stk.push(Integer.parseInt(st.nextToken()));
		idxStk.push(0);
		
		int[] ans = new int[n];
		ans[0] = -1;
		
		int now;
		for (int i = 1; i < n; i++) {
			ans[i] = -1;
			now = Integer.parseInt(st.nextToken());
			while(!stk.isEmpty()) {
				if(stk.peek() < now) {
					ans[idxStk.pop()] = now;
					stk.pop();
				}else
					break;
			}
			stk.push(now);
			idxStk.push(i);
//			System.out.println(stk);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(ans[i]).append(' ');
		}
		System.out.println(sb);
	}
}
