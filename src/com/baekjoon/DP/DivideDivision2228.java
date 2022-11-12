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
	int[][] sum;
	// int[] record;

	// int ans;
	
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//구간은 인접해선 안된다... 그걸 모르고 계속 풀고있었네
		//최대려면 양수 그냥 싹다 집어넣으면 최대임

		//구간을 M개로 나누었을 때, 최고의 합
		//구간이 X개 남았다면 남은 칸은 X + X-1개 있어야 함

		// record = new int[M];

		//y부터 x까지의 합6
		sum = new int[N][N];
		for (int i = 0; i < N; i++) {
			sum[i][i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				sum[i][j] = sum[i][j-1] + sum[j][j];
			}
		}

		//y위치에서 x개 선택한 상황에서의 기록
		//햄버거 다이어트?
		cache = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cache[i][j] = INF;
			}
		}

		int ans = dfs(0, 0);

		System.out.println(ans);
	}

	private int dfs(int starting, int select) {
		if(starting >= N)
			return INF;

		//하나만 더 고르면 되는 경우
		//나머지에서 걍 젤 큰 값 반환하기
		if(select == M - 1 && cache[starting][select] == INF){
			int max = INF; 
			for (int i = starting; i < N; i++) {
				for (int j = i; j < N; j++) {
					max = Math.max(max, sum[i][j]);
				}
			}

			cache[starting][select] = max;
			return max;
		}

		if(cache[starting][select] != INF){
			return cache[starting][select];
		}

		if(N - starting < (M - select) + (M - select - 1))
			return INF;

		int max = INF;

		for (int i = starting; i < N; i++) {
			for (int j = i; j < N; j++) {
				max = Math.max(max, sum[i][j] + dfs(j + 2, select + 1));
			}
		}
		
		return cache[starting][select] = max;
	}	
}
