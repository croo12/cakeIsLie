package com.baekjoon.element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SelectNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[N+1]; 
		for (int i = 1; i <= N; i++) {
			ans[i] = Integer.parseInt(br.readLine());
		}
		boolean[] vis = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			if(!vis[i]) {
				int next = i;
				while(!vis[next]) {
					q.offer(next);
					vis[next] = true;
					next = ans[next];
				}
				int now = 0;
				while(now != next && !q.isEmpty()) {
					now = q.poll();
				}
				if(now == next) q.add(now);
				while(!q.isEmpty()) {
					list.add(q.poll());
				}
			}
		}
		
		Collections.sort(list);
		int size = list.size();
		StringBuilder sb = new StringBuilder();
		sb.append(size).append('\n');
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.print(sb);
	}
}