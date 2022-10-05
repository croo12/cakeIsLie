package com.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PointSort11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(pq.poll().toString()).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static class Pair implements Comparable<Pair>{
		int r, c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int compareTo(Pair o) {
			int ans = Integer.compare(this.r, o.r);
			
			if(ans == 0) {
				return Integer.compare(this.c, o.c);
			}
			
			return ans;
		}
		
		@Override
		public String toString() {
			return r + " " + c;
		}
	}
}
