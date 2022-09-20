package com.baekjoon.backTracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NM3_15651 {
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		select(0);
		System.out.print(sb);
		sc.close();
	}

	private static void select(int idx) {
		if (idx == m) {
			Iterator<Integer> iter = list.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			;
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
			select(idx+1);
			list.remove(list.size()-1);
		}
	}
}
