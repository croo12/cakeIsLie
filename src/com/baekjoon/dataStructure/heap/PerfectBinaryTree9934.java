package com.baekjoon.dataStructure.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectBinaryTree9934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		int length = str.length;
		
		int[] tree = new int[length+1];
		boolean[] visited =new boolean[length+1];
		
		int now = (int)Math.pow(2, (K-1));
//		tree[now] = Integer.parseInt(str[0]);
//		visited[tree[now]] = true;
		
		boolean left;
		for (int i = 0; i < length; i++) {
			
			if(visited[tree[now]]) {
				i--;
				now= now/2;
				continue;
			}
			
			left = false;
			
			//왼쪽으로 보낼까?
			while(left == false) {
				if(now*2 > length) {
					left = true;
				}else if(visited[tree[now*2]]) {
					left = true;
				}else
					now = now*2;
			}
			
			//나 찍음
			tree[now] = Integer.parseInt(str[i]);
			visited[tree[now]] = true;
			
			//오른쪽으로 보낼까여
			if(now*2+1 > length) {
				now = now/2;
			}else if(visited[tree[now*2+1]]) {
				now = now/2;
			}else
				now = now*2+1;
		}
		StringBuilder sb = new StringBuilder();
		int line = 2;
		for (int i = 1; i < length+1; i++) {
			if(i==line) {
				sb.append("\n");
				line *= 2;
			}
			sb.append(tree[i]).append(" ");
		}
		System.out.println(sb);
	}
}
