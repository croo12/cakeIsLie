package com.beakjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewAverage {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		int now;
		for (int i = 0; i < n; i++) {
			now = Integer.parseInt(st.nextToken());
			sum += now;
			max = Math.max(max, now);
		}
		
		double avg = ((double)sum) / n;
		double pos = 100.0 / max;
		
		System.out.println(avg*pos);
//		System.out.println("평균 : " + avg);
//		System.out.println("변경 비율 : " + pos);
	}
}
