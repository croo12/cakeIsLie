package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhatIs17478 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static String[] s;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		s = new String[8];
		s[0] = "____";
		s[1] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		s[2] = "\"재귀함수가 뭔가요?\"";
		s[3] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		s[4] = "라고 답변하였지.";
		s[5] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		s[6] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		s[7] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		
		append(0,s[1]);
		ans(0);
		
		System.out.print(sb);
	}
	
	private static void ans(int depth) {
		append(depth,s[2]);

		if(depth == N) {
			append(depth,s[3]);
			append(depth,s[4]);
			return;
		}
		
		append(depth,s[5]);
		append(depth,s[6]);
		append(depth,s[7]);
		
		ans(depth+1);
		
		append(depth,s[4]);
	}
	
	private static void append(int N, String sentence) {
		for (int i = 0; i < N; i++) {
			sb.append(s[0]);
		}
		sb.append(sentence);
		sb.append('\n');
	}
}