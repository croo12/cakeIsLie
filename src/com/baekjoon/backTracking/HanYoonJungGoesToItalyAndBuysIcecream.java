package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HanYoonJungGoesToItalyAndBuysIcecream {
	
	static int N;
	static boolean[] check;
	static ArrayList<Integer>[] nope;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		check = new boolean[N+1];
		nope = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			nope[i] = new ArrayList<Integer>();
		}
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list1 = nope[i1];
			ArrayList<Integer> list2 = nope[i2];
			
			list1.add(i2);
			list2.add(i1);
		}
		
		backT(1,0);
		
		System.out.println(cnt);
	}
	
	static int cnt = 0;
	static int[] arr = new int[3];
	
	private static void backT(int idx, int depth) {
		if(depth == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(nope[arr[i]].contains(arr[j]))
						return;
				}
			}
			cnt++;
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			if(!check[i]) {
				check[i] = true;
				arr[depth] = i;
				backT(i,depth+1);
				check[i] = false;
			}
		}
	} 
}
