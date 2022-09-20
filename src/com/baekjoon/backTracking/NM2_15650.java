package com.baekjoon.backTracking;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class NM2_15650 {
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		select(1,0);
		System.out.print(sb);
		sc.close();
	}

	private static void select(int now, int idx) {
		if (idx == m) {
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			;
			sb.append("\n");
			return;
		}
		
		if(n - now + 1 < m - idx) return;

		set.add(now);
		select(now+1,idx + 1);

		set.remove(now);
		select(now+1,idx);
	}
}
