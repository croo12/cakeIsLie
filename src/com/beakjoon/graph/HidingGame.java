package com.beakjoon.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HidingGame {
	// try1 memory over
	// try2 wrong
	// try3 compile error

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

		sc.close();

		HashMap<Integer, Integer> cnt = new HashMap<>();

		if (x <= y) {
			Queue<Integer> q = new LinkedList<>();
			q.offer(x);
			cnt.put(x, 0);

			while (!q.isEmpty()) {
				int now = q.poll();
				int[] move = { 1, -1, now };

				if (now == y)
					break;

				for (int k = 0; k < 3; k++) {
					int next = now + move[k];

					if (next < x / 2 || next > 2 * y)
						continue;
					if (cnt.get(next) == null) {
						q.add(next);
						cnt.put(next, cnt.get(now) + 1);
					}
				}
			}
			System.out.println(cnt.get(y));
		} // if(x<=y)
		else {
			System.out.println(x - y);
		}
	}
}
