package com.baekjoon.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrinterQ1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());
			
			int[] q = new int[N];
			
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int now = Integer.parseInt(st.nextToken());
				pq.offer(now);
				q[i] = now;
			}
			
			int ans = 0;
			int idx = 0;
			while(!pq.isEmpty()) {
				ans++;
				int now = pq.poll();
				
				while(q[idx] != now) {
					idx++;
					if(idx == N)
						idx = 0;
				}
				
				q[idx] = -1;
				
				if(idx == o)
					break;
			}
			
			sb.append(ans).append('\n');
		}
		System.out.print(sb);
	}
}
