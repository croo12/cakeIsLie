package com.beakjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Treasure2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String[] a = new String[n];
		String[] b = new String[n];
		
		a = br.readLine().split(" ");
		b = br.readLine().split(" ");
		
		Integer[] rank = gotRank(a,b); //rank = b 값이 큰 순서대로 그 값의 인덱스를 저장
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(a[i]) * Integer.parseInt(b[rank[i]]);
		}
		
		System.out.println(sum);
	}
	
	private static Integer[] gotRank(String[] a, String[] b) {
		
		Arrays.sort(a, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.parseInt(o1) - Integer.parseInt(o2);
			}
		});
		
		Integer[] rank = new Integer[b.length];
		int cnt = 0;
		
		for (int i = 0; i < rank.length; i++) 
			rank[i] = cnt++;
		
		Arrays.sort(rank, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.parseInt(b[o2]) - Integer.parseInt(b[o1]);
			}
		});
		
		return rank;
	}
}
