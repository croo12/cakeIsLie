package com.baekjoon.dataStructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinAndMax2357 {
	public static void main(String[] args) {
		try {
			new MinAndMax2357().solution();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		var st = new StringTokenizer(br.readLine(), " ");
		var N = Integer.parseInt(st.nextToken());
		var M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		
		//세그먼트 트리의 높이
		int height = 0; 
		
		while( (1 << height) < N )
				height++;
		
		//최소 최대를 저장하는 세그먼트 트리
		int[][] segTree = new int[1 << height][2];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		makeTree(segTree, num, 0, N);
		
		
	}

	private void makeTree(int[][] segTree, int[] num, int start, int end) {
		
		
	}
	
	private class Node {
		int min, max;
		Node left, right;
		public Node(int min, int max, Node left, Node right) {
			super();
			this.min = min;
			this.max = max;
			this.left = left;
			this.right = right;
		}
	}
}
