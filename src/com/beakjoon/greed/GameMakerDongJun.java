package com.beakjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameMakerDongJun {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sc = new int[n];
		for (int i = 0; i < sc.length; i++) {
			sc[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for (int i = sc.length-1; i > 0; i--) {
			while(sc[i] <= sc[i-1]) {
				sc[i-1]--;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
