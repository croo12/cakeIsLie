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
		
		System.out.println(Arrays.toString(arr));
		
		int far = 0;
		boolean isMinus = false;
		int cntMinus = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i] < 0) {
				cntMinus++;
				if(far < arr[i] * -1) {
					far = arr[i] * -1; 
					isMinus = true;
				}
			}else {
				if(far < arr[i]) {
					far = arr[i];
					isMinus = false;
				}
			}
		}

		int len = 0;
		
		
//		if(isMinus) {
//			len += goPlus(cntMinus, arr, isMinus);
//			len += goMinus(cntMinus, arr, isMinus);
//		}else {
//			len += goMinus(cntMinus, arr, isMinus);
//			len += goPlus(cntMinus, arr, isMinus);
//		}
		
		System.out.println(len);
	}
	
	static int plus;
	static int minus;
	
	static int divide(int cntMinus, int[] arr, boolean isMinus) {
		plus = 0;
		minus = 0;
		if(cntMinus != n)
			comb(arr, cntMinus, n-1, 0);
		
		if(cntMinus != 0)
			comb(arr, 0, cntMinus, 0);
		
	}

	private static void comb(int[] arr, int left, int right, int depth) {
		if(depth == n/m) {
			
			return;
		}
		
		
		
	}
	
	
//	static int goPlus(int cntMinus, int[] arr, boolean isMinus) {
//		if(cntMinus == n) return 0;
//		
//		int idx = cntMinus - 1;
//		int len = 0;
//		while(true) {
//			if(n > idx + m)
//				len += arr[(idx = idx + m)] * 2;
//			else {
//				len += arr[n-1];
//				break;
//			}
//		}
//		
//		if(isMinus) len += arr[n-1];
//		
//		return len;
//	}
//	
//	static int goMinus(int cntMinus, int[] arr, boolean isMinus) {
//		if(cntMinus == 0) return 0;
//		
//		int idx = cntMinus;
//		int len = 0;
//		while(true) {
//			if(-1 < idx - m)
//				len += arr[(idx = idx - m)] * 2 * -1;
//			else {
//				len += arr[0] * -1;
//				break;
//			}
//		}
//		
//		if(!isMinus) len += arr[0] * -1;
//		
//		return len;
//	}
}
