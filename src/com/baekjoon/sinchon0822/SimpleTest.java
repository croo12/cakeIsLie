package com.baekjoon.sinchon0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SimpleTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for (int x = 1; x <= a; x++) {
				for (int y = 1; y <= b; y++) {
					for (int z = 1; z <= c; z++) {
						if(x%y == y%z && y%z == z%x)
							cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
