package com.baekjoon.sinchon0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HowMakeHandle_25498 {
	// 틀린이유
	// 1. 핸들의 길이가 긴게 나오고
	// 그 다음 길이가 짧고 사전상 더 뒤에있는 핸들이 나오는 경우
	// 잘못 출력할듯 -> 깊이 우선 탐색이라 틀림

	// 2. bfs여도 위 문제는 똑같이 일어남

	static char[] db;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] vis = new boolean[N + 1];
		db = new char[N + 1];

		String s = br.readLine();
		for (int i = 1; i <= N; i++) {
			db[i] = s.charAt(i - 1);
		}

		PriorityQueue<Integer>[] adjList = new PriorityQueue[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new PriorityQueue<>(custom);
		}

		StringTokenizer st;
		int left, right;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());

			adjList[left].add(right);
			adjList[right].add(left);
		}

		// 최대값 저장용
		char[] handle = new char[N];

		PriorityQueue<Integer> pq = new PriorityQueue<>(custom);

		pq.offer(1);
		vis[1] = true;

		// 레벨 탐색을 할건데 레벨에서 제일 높은값만 탐색할거임
		// 제일 높은값이 아니게 되면 깨야함

		// 지금이 레벨 몇인가
		int depth = 0;
		// 다음 레벨 저장용
		PriorityQueue<Integer> nextQ;

		int now;
		int tmp;
		while (!pq.isEmpty()) {
			handle[depth] = db[pq.peek()];
			nextQ = new PriorityQueue<>(custom);

			while (!pq.isEmpty()) {
				now = pq.poll();
				
				if(db[now] < handle[depth])
					break;
				
				while (!adjList[now].isEmpty()) {
					tmp = adjList[now].poll();

					if (vis[tmp])
						continue;

					vis[tmp] = true;
					nextQ.offer(tmp);
				}
			}

			pq = nextQ;
			depth++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N && handle[i] != 0; i++) {
			sb.append(handle[i]);
		}
		System.out.println(sb);
	}

	static Comparator<Integer> custom = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return Character.compare(db[o2], db[o1]);
		}
	};
}
