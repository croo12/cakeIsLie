package com.beakjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baseball17281 {
	static int N;
	static BaseMan[] team;
	static int[] check;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		team = new BaseMan[9];
		for (int i = 0; i < 9; i++) {
			team[i] = new BaseMan(N);
		}
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < 9; j++) {
				team[j].performance[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		check = new int[9];
		check[0] = 3;
		
		simulate(1);
		
		System.out.println(max);
	}
	
	private static void simulate(int cnt) {
		if(cnt == 9) {
			BaseMan[] order = new BaseMan[9];
			for (int i = 0; i < 9; i++) {
				order[check[i]] = team[i];
			}
			
			int score = 0;
			int num = 0;
			
			for (int i = 0; i < N; i++) {
				int outCount = 0;
				int base = 0;
				while(outCount != 3) {
					int[] sb = {0, base};
					switch(order[num++%9].performance[i]) {
					case 0:
						outCount++;
						break;
					case 1:
						sb = goBase(base, 1);
						break;
					case 2:
						sb = goBase(base, 2);
						break;
					case 3:
						sb = goBase(base, 3);
						break;
					case 4:
						sb = goBase(base, 4);
					}
					score += sb[0];
					base = sb[1];
				}
			}
			
			max = Math.max(max, score);
			
			return;
		}
		
		if(cnt == 3) {
			simulate(4);
			return;
		}
		
		for (int i = 1; i < 9; i++) {
			if(check[i] == 0) {
				check[i] = cnt;
				simulate(cnt+1);
				check[i] = 0;
			}
		}
	}
	
	static int[] goBase(int base,int n) {
		int score = 0;
		for (int i = 0; i < n; i++) {
			if(base/4 >= 1) {
				score++;
				base = base%4;
			}
			base = base*2;
			if(i == 0)
				base++;
		}
		
		int[] sb = {score, base};
		return sb;
	}
	
	static class BaseMan{
		int[] performance;
		public BaseMan(int N) {
			this.performance = new int[N];
		}
	}
}
