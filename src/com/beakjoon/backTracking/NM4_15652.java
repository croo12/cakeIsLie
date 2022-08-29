package com.beakjoon.backTracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NM4_15652 {
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();

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
			Iterator<Integer> iter = list.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = now; i <= n; i++) {
			list.add(i);
			select(i,idx+1);
			list.remove(list.size()-1);
		}
	}
}
