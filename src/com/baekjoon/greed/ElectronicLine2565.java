package com.baekjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ElectronicLine2565 {
	public static void main(String[] args) {
		try {
			new ElectronicLine2565().solution();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Comparator<int[]> comp = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[0], o2[0]);
		}
	};
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] line = new int[N][4];
		
		StringTokenizer st;
		
		//전선 제일 많이 교차된 것 부터 끊으면 무조건 이득 아님?
		//다만 전선의 개수는 계속 변동한다는 치명적인 문제점이 있다
		
		//하나 끊으면 이어져 있던 전선들의 교차 수가 줄어든다!!
		//어떻게 해야 전선 하나를 뽑고 나머지 교차되있던 전선들의 차수를 조정해 줄 수 있을까?
		
		//최대값 찾는건 N이면 됨 -> 그다음 최대값과 교차된 선의 수 만큼 연산
		
		//생각해보니 결론적으로 ans번 끊어야한다고 생각해보면
		//ans번의 가치를 극대화하는 방향으로 끊어야함
		
		//만약
		
		Node[] adjList = new Node[N];
		
		//총 전깃줄
		int total = 0;
		int idx;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			line[i][1] = Integer.parseInt(st.nextToken());
			line[i][2] = Integer.parseInt(st.nextToken());
			line[i][3] = i;
			idx = i - 1;
			while(idx >= 0) {
				if((line[i][1] - line[idx][1]) * (line[i][2] - line[idx][2]) < 0) {
					line[i][0]++;
					line[idx][0]++;
					total++;
					adjList[i] = new Node(idx, adjList[i]);
					adjList[idx] = new Node(i, adjList[idx]);
				}
				
				idx--;
			}
		}
		
		int ans = 0;
		int max;
		while(total > 0) {
			max = 0;
			idx = -1;
			for (int i = 0; i < N; i++) {
				if(line[i][0] > max) {
					max = line[i][0];
					idx = i;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	class Node{
		int data;
		Node next;
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
}
