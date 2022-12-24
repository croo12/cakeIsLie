package com.elses.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var N = Integer.parseInt(br.readLine());

		var st = new StringTokenizer(br.readLine(), " ");

		int max = 0;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			max = Math.max(now, max);
			sum += now;
		}

		int ans = Math.max(sum%2==0 ? sum/2 : (sum/2 + 1) , max);
		
		System.out.println(ans > 1440 ? -1 : ans);
	}
}