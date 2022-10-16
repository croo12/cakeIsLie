package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortByAge10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Member> pq = new PriorityQueue<>();
		String[] s;
		for(int idx = 0; idx < N; idx++) {
			s = br.readLine().split(" ");
			pq.offer(new Member(idx, Integer.parseInt(s[0]), s[1]));
		}
		
		StringBuilder sb = new StringBuilder();
		Member now;
		while(N-- > 0) {
			now = pq.poll();
			sb.append(now.age).append(' ').append(now.name).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static class Member implements Comparable<Member>{
		int idx, age;
		String name;
		public Member(int idx, int age, String name) {
			super();
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Member o) {
			int now = Integer.compare(this.age, o.age);
			if(now == 0)
				return Integer.compare(this.idx, o.idx);
			return now;
		}
	}
}
