package com.beakjoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VerticalReader {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[][] cs = new char[5][];
			for (int i = 0; i < 5; i++) {
				cs[i] = br.readLine().toCharArray();
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					try {
						sb.append(cs[j][i]);
					}catch(IndexOutOfBoundsException e) {
						continue;
					}
				}
			}
			System.out.println(sb);
		}
	}
}
