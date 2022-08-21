package com.beakjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DrinkingBeerAndWalking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			SanggunPair start = new SanggunPair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			SanggunPair[] beers = new SanggunPair[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				beers[i] = new SanggunPair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			SanggunPair end = new SanggunPair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
	}
}
class SanggunPair{
	int x;
	int y;
	public SanggunPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}