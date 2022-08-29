package com.beakjoon.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class NM5_15654 {
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
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		select(0);
		System.out.print(sb);
		sc.close();
	}

	private static void select(int idx) {
		if (idx == m) {
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				sb.append(iter.next()).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!check[i]) {
				set.add(arr[i]);
				check[i] = true;
				select(idx + 1);
				set.remove(set.size()-1);
				check[i] = false;
			}	
		}
	}
}