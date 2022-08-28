package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpecialNumberOfTenes {
	
	static boolean[] prime = new boolean[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i < 1000001; i++) {
			if(!prime[i])
				for (int j = i*2; j < 1000001; j+=i) {
					prime[j] = true;
				}
		}
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			char specialN = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for (int i = start; i <= end; i++) {
				if(!prime[i]) {
					char[] parts = (""+i).toCharArray();
					for (int j = 0; j < parts.length; j++) {
						if(parts[j] == specialN) {
							cnt++;
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
}
