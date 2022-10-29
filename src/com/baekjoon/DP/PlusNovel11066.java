package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PlusNovel11066 {
	public static void main(String[] args) {
		try {
			new PlusNovel11066().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int N;
	int[] number;
	int[][] cache;
	int[][] ans;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			number = new int[N];
			cache = new int[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < N; j++) {
					cache[i][j] = -1;
				}
				cache[i][i] = 0;
			}
			
			for (int i = 0; i < N - 1; i++) {
				cache[i][i+1] = number[i] + number[i+1];
			}
			
			sb.append(makeBook(0, N-1, N)).append('\n');

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%4d",cache[i][j]);
				}
				System.out.println();
			}
		}
		System.out.print(sb);
	}
	
	public int makeBook(int st, int ed, int comp) {
		if(cache[st][ed] != -1)
			return cache[st][ed];
		
		int min = 987654321;
		
		int now = 0;
		
		for (int i = st; i < ed; i++) {
			int tmp = makeBook(st, i, i - st + 1) + makeBook(i + 1, ed, ed - i);
			if(tmp < min) {
				min = tmp;
			}
		}
		
		if(comp >= 2)
			for (int i = st; i <= ed; i++) {
				now += number[i];
			}
		
		cache[st][ed] = min + now;
		
		return cache[st][ed];
	}
}
