package com.baekjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Congress1226 {
	static int N;
	static Party[] user;
	
	static int half;
	static int max;
	static Node best;
	static int bestCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Party> arr = new PriorityQueue<>(N);
		half = 0;
		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr.offer(new Party(i, now));
			half += now;
		}
		
		user = arr.toArray(new Party[0]);
		
		half = half/2 + 1;
		max = 0;
		
		//큰것부터 넣어서 만들면 되는거 아님?
		//값의 맥스를 초과하면 return하기
		//여태까지 구해진 max초과값보다 작으면 리턴하기
		
		comb(0,0,0,0,null);
		
		StringBuilder sb = new StringBuilder();
		sb.append(bestCnt).append('\n');
		PriorityQueue<Integer> pq = new PriorityQueue<>(bestCnt);
		while(best != null) {
			pq.offer(best.val);
			best = best.next;
		}
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append(' ');
		}
		
//		System.out.println(half + max);
		System.out.println(sb);
	}
	
	static void comb(int idx, int sum, int last, int cnt, Node curr) {
		if(sum >= half) {
			int over = sum - half;
			if(last <= over)
				return;
			
			if(over > max) {
				max = over;
				best = curr;
				bestCnt = cnt;
			}
			
			return;
		}
		
		if(idx >= N) return;
		Party now = user[idx];
		if(now.val <= max) return;
		
		//우리당에 합류하시오
		comb(idx+1, sum + now.val, now.val, cnt+1, new Node(now.idx, curr));
		//우리당에 합류하지 마시오
		comb(idx+1, sum, last, cnt, curr);
	}
	
	static class Party implements Comparable<Party>{
		int idx;
		int val;
		
		Party(int idx, int val){
			this.idx = idx;
			this.val = val;
		}
		
		@Override
		public int compareTo(Party o) {
			return Integer.compare(o.val, this.val);
		}
	}
	
	static class Node{
		int val;
		Node next;
		Node(int val, Node next){
			this.val = val;
			this.next = next;
		}
	}
}
