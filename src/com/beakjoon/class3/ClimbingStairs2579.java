package com.beakjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		boolean rule = false;
		int sum = 0;
		sum += arr[n-1];
		for (int i = n-1; i >= 1; i--) {
			
			if(i == 1 && !rule) {
				sum+= arr[i-1];
				break;
			}else if(i == 1) {
				break;
			}
			
			if(arr[i-1] < arr[i-2] || rule) {
				sum += arr[i-2];
				i = i-1;
				rule = false;
			}else {
				sum += arr[i-1];
				rule = true;
			}
		}
		System.out.println(sum);
	}
}
