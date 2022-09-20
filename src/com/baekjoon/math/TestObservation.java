package com.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TestObservation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		int now;
		for (int i = 0; i < N; i++) {
			now = arr[i] - B;
			cnt++;
			if(now <= 0)
				continue;
			else {
				if(now % C == 0)
					cnt += now/C;
				else
					cnt += now/C + 1;
			}
		}
		
		System.out.println(cnt);
	}
}
