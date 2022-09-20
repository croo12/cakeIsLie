package com.baekjoon.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class NM9_15663 {
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> set = new ArrayList<>();
	static int[] arr;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		check = new boolean[n];
		select(0);
		System.out.print(sb);
		sc.close();
	}

	private static void select(int cnt) {
		if (cnt == m) {
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
			return;
		}

		int last = -1;
		int now;
		for (int i = 0; i < n; i++) {
			now = arr[i];
			if (!check[i] && last != now) {
				last = now;
				set.add(arr[i]);
				check[i] = true;
				select(cnt + 1);
				set.remove(set.size() - 1);
				check[i] = false;
			}
		}
	}
}