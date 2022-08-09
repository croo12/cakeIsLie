package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flattern2 {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			
			for (int i = 0; i < N; i++) {
				doDump();
			}
			
			int max = 0;
			int min = 0;
			for(int i = 1; i < 101; i++) {
				if(arr[i] != 0 && min != 0) { 
					min = i;
				}
				if(arr[101-i] != 0 && max != 0) {
					max = 101 - i;
				} 
			}
			
			System.out.printf("#%d %d\n", 10-T, max-min);
		}
	}
	
	private static void doDump() {
		int max = 0;
		int min = 0;
		for(int i = 1; i < 101; i++) {
			if(arr[i] != 0 && min == 0) { 
				min = i;
			}
			if(arr[101-i] != 0 && max == 0) {
				max = 101 - i;
			} 
		}
		arr[max]--;
		arr[max-1]++;
		arr[min]--;
		arr[min+1]++;
	}
}
