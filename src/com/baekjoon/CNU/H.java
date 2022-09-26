package com.baekjoon.CNU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int last = 0;
		int cnt = 1;
		int tmp = 1;
		for (int i = N - 1; i >= 0; i--) {
			int now = arr[i];
			
			if(now == last) {
				tmp++;
			}else {
				tmp = 1;
			}
			
			if(tmp > cnt)
				cnt = tmp;
			
			last = now;
		}
		
		System.out.println(cnt);
	}
}
