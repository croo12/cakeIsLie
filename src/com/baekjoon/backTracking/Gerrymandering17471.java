package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gerrymandering17471 {
	
	static ArrayList<Integer>[] roads;
	static int N;
	static int[] pop;
	
	static int totalPop;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N+1];
		
		totalPop = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			totalPop += (pop[i] = Integer.parseInt(st.nextToken()));
		}
		
		roads = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			roads[i] = new ArrayList<>();
			
			for (int j = 0; j < M; j++) {
				int side = Integer.parseInt(st.nextToken());
				roads[i].add(side);
			}
		}
		
		
		
		
	}
	
}
