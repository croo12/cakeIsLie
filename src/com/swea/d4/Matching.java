package com.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matching {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			char[] cs = br.readLine().toCharArray();
			int[] cnt = new int[4];
			char now;
			for (int i = 0; i < n; i++) {
				now = cs[i];
				switch (now) {
				case '<':
					cnt[0]++;
					break;
				case '(':
					cnt[1]++;
					break;
				case '{':
					cnt[2]++;
					break;
				case '[':
					cnt[3]++;
					break;
				case '>':
					cnt[0]--;
					break;
				case ')':
					cnt[1]--;
					break;
				case '}':
					cnt[2]--;
					break;
				case ']':
					cnt[3]--;
					break;
				}
			}
			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				if(cnt[i] != 0)
					flag = false;
			}
			if(flag) System.out.printf("#%d 1\n",tc);
			else System.out.printf("#%d 0\n",tc);
		}
	}
}
