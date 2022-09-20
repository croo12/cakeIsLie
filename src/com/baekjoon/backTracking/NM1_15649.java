package com.baekjoon.backTracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NM1_15649 {
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> set = new ArrayList<>();
	static boolean[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		check = new boolean[n+1];
		select(0);
		System.out.print(sb);
		sc.close();
	}
	
	
	private static void select(int idx) {
		if(idx == m) {
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			};
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(!check[i]) {
				set.add(i);
				check[i] = true;
				select(idx+1);
				
				set.remove(set.size()-1);
				check[i] = false;
			}
		}
	}
}
