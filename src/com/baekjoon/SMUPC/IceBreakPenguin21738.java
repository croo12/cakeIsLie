package com.baekjoon.SMUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IceBreakPenguin21738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		//연결점이 두개인 블럭은 펭귄이 지나가도 안깨짐
		//하나인 블럭은 깨짐, 얼음을 몇개나 깰 수 있는가?
		//제일 긴 경로 찾기 -> 이건 등산로와 유사한 문제임
		
		//처음에 깨지는 블럭과 안깨지는 블럭 구분하기 -> 어떻게?
		

		//그리고 제일 많이 얼음깨는 경로를 dfs로 찾기
		
	}
	
}
