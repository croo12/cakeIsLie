package com.beakjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EnergyDrink {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		int maxIdx = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		
		double sum = max;
		
		for (int i = 0; i < N; i++) {
			if(i != maxIdx) {
				sum += (arr[i]/2.0);
			}
		}
		
		System.out.println(sum);
	}
}
