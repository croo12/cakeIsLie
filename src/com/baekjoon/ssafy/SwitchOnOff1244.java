package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnOff1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		boolean[] switchs = new boolean[t + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= t; i++) {
			if (st.nextToken().equals("1")) {
				switchs[i] = true;
			}
		}

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {

			int tmp = 0;
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {// 남자임
				tmp = Integer.parseInt(st.nextToken());
				for (int j = 1; j <= t; j++) {
					if (j % tmp == 0) {
						switchs[j] = !switchs[j];
					}
				}
			} else {
				tmp = Integer.parseInt(st.nextToken());
				switchs[tmp] = !switchs[tmp];
				for (int j = 1; ((tmp + j) <= t) && ((tmp - j) >= 1); j++) {
					if (switchs[tmp + j] == switchs[tmp - j]) {
						switchs[tmp + j] = !switchs[tmp + j];
						switchs[tmp - j] = !switchs[tmp - j];
					}else {
						break;
					}
				}
			}

		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= t; i++) {
			if (switchs[i]) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			if (i % 20 == 0)
				sb.append("\n");
			else
				sb.append(" ");
		}
		System.out.println(sb);
	}
}
