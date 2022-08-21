package com.beakjoon.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLiquid {
	
	static int finalResult = 2000000001;
	static int finalA = 0;
	static int finalB = 0;
	
	static int[] arr;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
//		Arrays.sort(arr);
		searchValue();
		
		System.out.println(arr[finalA] + " " + arr[finalB]);
	}
	
	private static int absoluteValue(int value) {
		if(value >= 0) return value;
		else return -1 * value;
	}
	
	private static void searchValue() {
		for (int i = 0; i < n; i++) {
//			System.out.println(i+"번 가동");
			int ans = arr[i];
			
			int start = i+1;
			int end = n-1;
			int mid = (start + end)/2;
			
			int result = 2000000001;
			int tmpA = 0;
			int tmpB = 0;
			
			while(end >= start) {
				int sum = ans + arr[mid];
				int av = absoluteValue(sum);
				if(sum > 0 ) {
					end = mid -1;
					if(result > av) {
						result = av;
						tmpA = i;
						tmpB = mid;
					} 
				}else if(sum < 0) {
					start = mid +1;
					if(result > av) {
						result = av;
						tmpA = i;
						tmpB = mid;
					} 
				}else {
					finalA = i;
					finalB = mid;
					finalResult = av;
					return;
				}
				mid = (start + end)/2;
			}
			
			if(result < finalResult) {
				finalResult = result;
				finalA = tmpA;
				finalB = tmpB;
			}
		}//for
	}
}
