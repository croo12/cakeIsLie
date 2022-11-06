package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivideDivision2228 {
	public static void main(String[] args) {
		try {
			new DivideDivision2228().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int INF = -987654321;
	
	int N;
	int M;
	int[][] cache;
	int[] sum;
	
	int[] numbers;
	
	int ans;
	
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cache = new int[N][N];
		sum = new int[M];
		
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			cache[i][i] = numbers[i];
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = INF;
			}
		}
		
		//구간 나눠서 값 저장하기
		//div 수만큼 나눠지면 sum에서 젤 큰 수 체크해서 저장하기
		
		
		ans = INF;
		
		div(-1, 0);
		
		System.out.println(ans);
	}

	private void div(int idx, int divNum) {
		if(idx == N-1 && divNum == M) {
			for (int i = 0; i < M; i++) {
				ans = Math.max(ans, sum[i]);
			}
			return;
		}
		
		if(idx == N-1 || divNum == M)
			return;
		
		for (int i = idx + 1; i < N; i++) {
			if(cache[idx + 1][i] == INF) {
				cache[idx + 1][i] = 0;
				for (int j = idx + 1; j <= i; j++) {
					cache[idx + 1][i] += numbers[j];
				}
			}
			
			sum[divNum] = cache[idx+1][i];
			
			div(i, divNum+1);
		}
	}
}
