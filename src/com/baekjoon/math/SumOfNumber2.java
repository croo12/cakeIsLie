package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNumber2 {
	public static void main(String[] args) {
		try {
			new SumOfNumber2().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int cnt = 0;
		
		while(st.hasMoreTokens())
			numbers[++cnt] = Integer.parseInt(st.nextToken());
		
		int ans = 0;

		int sum = 0;
		int last = 0;
		cnt = 0;
		
		int now;
		while(cnt < N) {
			now = numbers[++cnt];
			
			
			sum += now;

			while(sum > M) 
				sum -= numbers[++last];
			
			if(sum == M) {
				ans++;
				sum -= numbers[++last];
			}
		}
		
		System.out.println( ans );
		
	}
}
