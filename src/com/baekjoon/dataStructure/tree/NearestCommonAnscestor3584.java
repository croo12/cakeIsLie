package com.baekjoon.dataStructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class NearestCommonAnscestor3584 {
	public static void main(String[] args) {
		try {
			new NearestCommonAnscestor3584().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		var sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int[] p = new int[N+1];
			boolean[] vis = new boolean[N+1];

			//트리 그리기
			while(--N > 0) {
				int[] mp = Stream
						   .of(br.readLine().split(" "))
						   .mapToInt(string -> Integer.parseInt(string))
						   .toArray();
				
				p[mp[1]] = mp[0];
			}
			
			//구해야 하는 두 노드
			int[] two = Stream
						.of(br.readLine().split(" "))
						.mapToInt(string -> Integer.parseInt(string))
						.toArray();
			
			int left = two[0];
			
			while(left != 0) {
				vis[left] = true;
				left = p[left];
			}
			
			int right = two[1];
			int ans = -1;
			
			while(true) {
				
				if(vis[right]) {
					ans = right;
					break;
				}
				
				right = p[right];
			}
			
			sb.append(ans).append('\n');
		}
		
		System.out.print(sb);
	}
}
