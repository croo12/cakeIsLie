package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PairSort2_11651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int now = Integer.compare(o1[1], o2[1]);
				if(now == 0 ) {
					return Integer.compare(o1[0], o2[0]);
				}
				return now;
			}
		});
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.offer(new int[] {x,y});
		}
		
		StringBuilder sb = new StringBuilder();
		int[] now;
		while(!pq.isEmpty()) {
			now = pq.poll();
			sb.append(now[0]).append(' ').append(now[1]).append('\n');
		}
		System.out.print(sb);
	}
}
