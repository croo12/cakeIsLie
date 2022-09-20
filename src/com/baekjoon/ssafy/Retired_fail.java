package com.baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retired_fail {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] day_table = new int[n];
		int[] money_table = new int[n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day_table[i] = Integer.parseInt(st.nextToken());
			money_table[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n-1; i >0; i--) {
			solution(i,n, day_table, money_table);
		}
		
	}
	
	public static void solution(int i, int n, int[] day_table, int[] money_table) {
		int[] exp = new int[n];
		int price = 0;
		if(day_table[i] > 1) {
			
		}else {
			price = money_table[i];
		}
		
		if(price <= 0) {
//			day_table[i];
		}
	}
}
