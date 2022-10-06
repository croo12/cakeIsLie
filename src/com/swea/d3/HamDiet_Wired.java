package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HamDiet_Wired {
	
	static int N;
	static int L;
	
	static int[] scores;
	static int[] kcals;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			scores = new int[N+1];
			kcals = new int[N+1];
			
			for (int i = 1; i <= N; i++) {
				st= new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				kcals[i] = Integer.parseInt(st.nextToken());
			}
			
			//최종값 나(L)에게 도달하는 방법은 무엇인가?
			best = new int[L+1];
			int ans = makeBurger(0,L);
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.print(sb);
	}
	
	static int[] best;
	
	static int makeBurger(int check, int kcal) {
		
		return 0;
	}
}
