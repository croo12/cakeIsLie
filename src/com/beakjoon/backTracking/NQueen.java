package com.beakjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

	static int cnt;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new int[N];

		search(0);

		System.out.println(cnt);
	}

	static int[] list;

	private static void search(int idx) {
		if (idx == N) {
			cnt++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check(idx,i)) {
				list[idx] = i;
				search(idx + 1);
				list[idx] = 0;
			}
		}
	}
	
	private static boolean check(int idx, int i) {
		for (int k = 0; k < idx; k++) {
			if (Math.abs(list[k] - i) == Math.abs(k - idx) || list[k] == i) {
				return false;
			}
		}
		return true;
	}
}
