package com.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Library1461 {
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[] arr = Arrays.stream(br.readLine().split(" "))
						  .mapToInt(s -> Integer.parseInt(s))
						  .sorted()
						  .toArray();
		
		int far = 0;
		int cntMinus = 0;
		
		//최댓값 구하고, 0 기준으로 양쪽 구분하기
		for (int i = 0; i < n; i++) {
			if(arr[i] < 0) {
				cntMinus++;
				if(far < arr[i] * -1) {
					far = arr[i] * -1; 
				}
			}else {
				if(far < arr[i]) {
					far = arr[i];
				}
			}
		}

		int plus = n - cntMinus;
		int minus = cntMinus;
		
		int len = 0;
		//m을 최대한 꽉채워서 성큼성큼 가기 -> 실패
		//+와 - 쪽 중 m으로 나누어 떨어지지 않는 부분이 있으면 그 나머지 만큼 쩌리를 먼저 왕복 이동해야 최소일 듯?
		//왕복이니 전부 * 2해줌. 그리고 가장 긴 거리만 빼면 됨
		
		if(plus % m == 0) {
			for (int i = cntMinus -1 + m; i <= cntMinus - 1 + plus; i+= m) {
				len += arr[i] * 2;
			}
		}else {
			len += arr[cntMinus - 1 + plus%m]*2;
			
			for (int i = cntMinus - 1 + plus%m + m; i <= cntMinus - 1 + plus; i+= m) {
				len += arr[i] * 2;
			}
		}
		
		if(minus % m == 0) {
			for (int i = cntMinus - m; i >= cntMinus - minus; i-= m) {
				len += arr[i] * 2 * -1;
			}
		}else {
			len += arr[cntMinus - minus%m] * 2 * -1;
			
			for (int i = cntMinus - minus%m - m; i >= cntMinus - minus; i-= m) {
				len += arr[i] * 2 * -1;
			}
		}
		
		System.out.println(len - far);
	}
}
