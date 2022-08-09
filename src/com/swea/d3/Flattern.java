package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Flattern {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
			
			for (int i = 0; i < N; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}
			
			Arrays.sort(arr);
			
			System.out.println(arr[99]-arr[0]);
			
		}
	}
}
