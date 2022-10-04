package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BrainF__kInterPrinter3954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			long[] memory = new long[M];
			
			int C = Integer.parseInt(st.nextToken());
			String order = br.readLine();
			
			int I = Integer.parseInt(st.nextToken());
			String input = br.readLine();
			
			//숫자 0 ~ 255까지
			//이거 그냥 빡구현 문제 아닌가?
			int idx = -1;
			int LIMIT = 100000002;
			boolean[] check = new boolean[C];
			int cursor = 0;
			int left = C;
			int right = -1;
			int dIdx = 0;
			while(LIMIT-- > 0 && idx < C-1) {
				idx++;
				switch(order.charAt(idx)) {
				case '-':
					memory[cursor]--;
					if(memory[cursor] < 0) {
						memory[cursor] = 255;
					}
					break;
					
				case '+':
					memory[cursor]++;
					if(memory[cursor] > 255) {
						memory[cursor] = 0;
					}
					break;
					
				case '<':
					cursor--;
					if(cursor < 0) {
						cursor = M-1;
					}
					break;
					
				case '>':
					cursor++;
					if(cursor == M) {
						cursor = 0;
					}
					break;
					
				case '[':
					if(memory[cursor] == 0) {
						while(order.charAt(idx) != ']')
							idx++;
					}
					break;
					
				case ']':
					if(memory[cursor] != 0) {
						
						if(right < idx) {
							if(!check[idx]) {
								check[idx] = true;
							}else if(check[idx]) {
								right = idx;
							}
						}
						int tmp = 0;
						while(tmp > -1) {
							idx--;
							if(order.charAt(idx) == '[')
								tmp--;
							else if(order.charAt(idx) == ']')
								tmp++;
						}
						if(left > idx) {
							if(!check[idx]) {
								check[idx] = true;
							}else if(check[idx]) {
								left = idx;
							}
						}
					}
					break;
				
				case ',':
					if(dIdx == I-1) {
						memory[cursor] = 255;
					}else {
						memory[cursor] = input.charAt(dIdx);
						dIdx++;
					}
					break;
					
				default : 
				}
			}
//			System.out.println(idx + "   " + order.charAt(idx));
			if(LIMIT <= 0) sb.append("Loops "+left+" "+right+"\n");
			else sb.append("Terminates\n");
		}
		System.out.print(sb);
	}
}
