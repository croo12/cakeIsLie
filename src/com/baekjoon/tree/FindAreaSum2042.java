package com.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindAreaSum2042 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SeguTree sgtr = new SeguTree(n);
		sgtr.init(arr, 1, 0, n-1);
		
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int time = m+k;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < time; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long diff = c - arr[b-1]; 
				arr[b-1] = c;
				sgtr.update(1, 0, n-1, b-1, diff);
			}else {
				sb.append(sgtr.sum(1, 0, n-1, b-1, (int)c-1)).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	static class SeguTree{
		private long[] tree;
		int size;
		
		SeguTree(int n){
			int h = (int) Math.ceil(Math.log(n)/Math.log(2));
			this.size = (int) Math.pow(2,h+1);
			tree = new long[size];
		}
		
		long init(long[] arr, int node, int start, int end) {
			if(start == end)
				return tree[node] = arr[start];
			else
				return tree[node] = init(arr,node*2,start,(start+end)/2) + init(arr, node*2+1,(start+end)/2 + 1,end);
		}
		
		void update(int node, int start, int end, int idx, long diff) {
			if(idx < start || end < idx) return;
			
			//차를 저장
			tree[node] += diff;
			
			if(start != end) {
				update(node*2, start, (start+end)/2, idx, diff);
				update(node*2 + 1, (start+end)/2 + 1, end, idx, diff);
			}
		}
		
		long sum(int node, int start, int end, int left, int right) {
			if(left > end || right < start)
				return 0;
			
			if(left <= start && right >= end)
				return tree[node];
			
			return sum(node*2, start, (start+end)/2, left, right) + sum(node*2 + 1, (start+end)/2 +1 , end , left, right);
		}
	}
}
