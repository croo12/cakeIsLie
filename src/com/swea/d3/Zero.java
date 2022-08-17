package com.swea.d3;

import java.util.Scanner;
import java.util.Stack;

public class Zero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int tc = 1; tc <= N; tc++) {
			int k = sc.nextInt();
			
			Stack<Integer> stk = new Stack<>();
			
			for (int i = 0; i < k; i++) {
				int now = sc.nextInt();
				if(now == 0) {
					stk.pop();
				}else {
					stk.push(now);
				}
			}
			
			int sum = 0;
			while(!stk.isEmpty()) {
				sum += stk.pop();
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
		sc.close();
	}
}
