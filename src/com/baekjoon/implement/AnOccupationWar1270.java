package com.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AnOccupationWar1270 {
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			check(br);
			map.clear();
		}
		System.out.print(sb);
	}
	
	static void check(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String now = st.nextToken();
			
			Integer value = map.get(now);
			if(value == null)
				value = 1;
			else {
				value++;
			}
			
			if(value > N/2) {
				sb.append(now).append('\n');
				return;
			}else {
				map.put(now, value);
			}
		}
		sb.append("SYJKGW").append('\n');
	}
}
