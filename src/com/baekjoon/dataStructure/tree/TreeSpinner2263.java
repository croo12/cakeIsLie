package com.baekjoon.dataStructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TreeSpinner2263 {
	public static void main(String[] args) {
		try {
			new TreeSpinner2263().solution();
		} catch (IOException e) {
			System.out.println("input err");
			e.printStackTrace();
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		tree = new Node[N+1];
		orders = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			tree[i] = new Node(i);
			orders.put(i, new int[2]);
		}
		
		io = new int[N];
		po = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			io[i] = now;
			orders.get(now)[0] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			po[i] = now;
			orders.get(now)[1] = i;
		}

		//인오더 LMR
		//포스트오더 LRM
		//프리오더 MLR를 구하세요
		//언제나 트리 탑은 포스트 오더의 마지막에 있는 친구 아님?
		//굿
		
		//io와 po가 달라지는 순간. 
		//io는 나를 찍었는데 po는 오른쪽으로 넘어가 버린것
		//io가 찍은 나로 돌아올때 까지 po는 오른쪽을 돌고 있다
		
		//루트를 찾자 루트는 나의 원수
		dfs(0, N-1, 0, N-1);
		
		System.out.println(sb);
	}
	
	StringBuilder sb = new StringBuilder();
	Node[] tree;
	int[] io;
	int[] po;
	HashMap<Integer, int[]> orders;
	
	public void dfs(int ist, int ied, int pst, int ped) {
		if(ist > ied || pst > ped)
			return;
		
		//인오더 LMR
		//포스트오더 LRM
		
		//내가 루트라면 io의 내 위치가 나의 왼쪽 오른쪽을 가르는 기준임
		//po에서 io에서의 내 위치 앞에 있는 놈이 바로 내 왼쪽노드임
		
		//루트
		int data = po[ped];
		sb.append(data).append(' ');
		
		//now[0] = 루트노드의 내 위치 -> 이 기준으로 좌우가 갈림
		int[] now = orders.get(data);
		
		int lRange = now[0] - ist;
		
		//left
		dfs(ist, now[0] - 1, pst, pst + lRange - 1);
		
		//right
		dfs(now[0] + 1, ied, pst + lRange, ped-1);
	}
	
	class Node{
		int data;
		Node left, right, parent;
		public Node(int data) {
			this.data = data;
		}
	}
}
