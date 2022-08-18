package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CutIronStick {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			Stack<String> stk = new Stack<>();
			String[] s = br.readLine().split("");
			
			int sum = 0;
			boolean flag = false;
			
			for (int i = 0; i < s.length; i++) {
				if(s[i].equals("(")) {
					stk.push(s[i]);
					flag = true;
					sum++;
				}else {
					if(flag) {
						stk.pop();
						sum--;
						sum += stk.size();
						
						flag = false;
					}else {
						stk.pop();
					}
				}
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
	}
}
