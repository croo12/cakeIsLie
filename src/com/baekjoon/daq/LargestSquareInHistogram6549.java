package com.baekjoon.daq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestSquareInHistogram6549 {
	public static void main(String[] args) {
		try {
			new LargestSquareInHistogram6549().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	int N;
	int[] sqs;
	
	void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//분할 정복으로 풀 수 있지 않을까?
		//근데 반씩 나눠서 구하면 홀수일 때는 어떻게함
		//짝이 안맞으면 어떻게함!!!
		
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if(N == 0)
				break;
			
			sqs = new int[N];
			for (int i = 0; i < N; i++) {
				sqs[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans = daq(0, N-1);
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	long daq(long left, long right) {
		if(left == right)
			return sqs[(int)right];
		
		long mid = (left + right)/2;
		
		long ans = Math.max(daq(left, mid), daq(mid+1, right));
		
		long L = mid;
		long R = mid + 1;
		int height = Math.min(sqs[(int)L] , sqs[(int)R]);
		
		ans = Math.max(ans, height * 2);
		
		while(left < L || R < right) {
			if(R < right && (L == left || sqs[(int)L-1] < sqs[(int)R+1])) {
				R++;
				height = Math.min(height, sqs[(int)R]);
			}
			else {
				L--;
				height = Math.min(height, sqs[(int)L]);
			}
			
			ans = Math.max(ans, height * (R - L + 1));
		}
		
		return ans;
	}
}
