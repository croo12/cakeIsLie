package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin9084 {
	
	static int N;
	static int[] coins;
	static int target;
	
	static int[][] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		//동전 갯수가 변하는 DP
		//최종값에 도달하는 방법의 가짓수는?
		//(최종값 - 동전) 값에 도달하는 방법의 가짓수의 합 같지만
		//동전을 추가하는 것으로 동전의 갯수가 같게 된다면 그건 서로 같은 방법임
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			coins = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			target = Integer.parseInt(br.readLine());
			
			count = new int[N][target+1];
			
			int coin = coins[0];
			for (int i = 1; i <= target; i++) {
				if(i%coin == 0)
					count[0][i]++;
			}
			
			for (int i = 1; i < N; i++) {
				coin = coins[i];
				for (int j = 1; j <= target; j++) {
					count[i][j] += count[i-1][j];

					for (int k = 1; k <= target; k++) {
						if(j - coin*k > 0)
							count[i][j] += count[i - 1][j - coin*k];
						else
							break;
					}
					
					if(j%coin == 0)
						count[i][j]++;
				}
			}
			
			sb.append(count[N-1][target]).append('\n');
		}
		
		System.out.print(sb);
	}
}
