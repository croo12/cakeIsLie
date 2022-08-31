package com.beakjoon.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class NM6_15655 {
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> set = new ArrayList<>();
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		select(0, 0);
		System.out.print(sb);
		sc.close();
	}

	private static void select(int prev, int idx) {
		if (idx == m) {
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
			return;
		}

		if (n - prev < m - idx)
			return;

		for (int i = prev; i < n; i++) {
			set.add(arr[i]);
			select(i + 1, idx + 1);
			set.remove(set.size() - 1);
		}
	}
}