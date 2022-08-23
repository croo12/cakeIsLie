package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Heap_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			int n = Integer.parseInt(br.readLine());

			PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				if (Integer.parseInt(st.nextToken()) == 1) {
					q.offer(Integer.parseInt(st.nextToken()));
				} else {
					Integer now = q.poll();
					if (now == null)
						now = -1;
					sb.append(now).append(" ");
				}
			}

			System.out.println(sb);
		}
	}
}
