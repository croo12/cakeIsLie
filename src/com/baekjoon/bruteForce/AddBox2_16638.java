package com.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddBox2_16638 {
	
	static int N;
	static int max;
	
	static int[] operatorsAndNumbers;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		operatorsAndNumbers = new int[N];
		check = new boolean[N];
		for (int i = 0; i < N; i++) {
			operatorsAndNumbers[i] = ((i%2 != 0) ? br.read() : (br.read()-'0'));
		}
		
		//중간에 곱하기 계산만 추가하면 되는거 아님?
		//곱하기로 바뀌면서 칸을 조정하면 중간에 있는 연산자랑 값이 겹쳐버릴지도?
		//아직 안푼문제임
		
		max = Integer.MIN_VALUE;
		comb(0, 0);
		System.out.println(max);
	}
	
	static void comb(int n, int cnt) {
		if( n == N/2) {
			int len = N-cnt*2;
			int[] last = new int[len];
			int idx = -1;
			for (int i = 0; i < N; i++) {
				idx++;
				if(check[i]) {
					last[idx] = calc(i, operatorsAndNumbers);
					i = i+2;
				}else {
					last[idx] = operatorsAndNumbers[i];
				}
			}
			
			for (int i = 0; i < len; i+=2) {
				if(i == len - 1)
					break;
				
				last[i+2] = calc(i,last);
			}
			
			max = Math.max(last[len-1], max);
			
			return;
		} // 탈출
		
		if(!check[n*2]) {
			for (int i = n*2; i <= n*2 + 2; i++) {
				check[i] = true;
			}
			comb(n+1,cnt+1);
			for (int i = n*2; i <= n*2 + 2; i++) {
				check[i] = false;
			}
		}
		
		comb(n+1,cnt);
		
	}
	
	static int calc(int idx, int[] arr) {
		// * : 42 // + : 43 // - : 45
		switch(arr[idx+1]) {
		case 42 :
			return arr[idx] * arr[idx+2];
		case 43 :
			return arr[idx] + arr[idx+2];
		case 45 :
			return arr[idx] - arr[idx+2];
		}
		return 0;
	}
}
