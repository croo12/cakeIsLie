package com.baekjoon.daq.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestAscendingNumbers4_14002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Node[] snake = new Node[T+1];
		snake[0] = new Node(0, null);
		for (int i = 1; i < T; i++) {
			snake[i] = new Node(1001, snake[i - 1]);
		}
		int length = 0;

		// 바꿔치기 술로 만들기.
		// snake 배열에 받는 숫자를 저장하기
		// 그런데 내가 본래 가지고 있던 수보다 큰 수가 나오면
		// 본래 가지고 있던 수 중 지금 나온 수보다 작으면서 가장 큰 수 자리랑 바꾸기

		// 그럼 이 때 이진탐색을 사용할 수 있을다
		// 하지만 이번엔 경로도 기억해야한다.

		// 연결리스트의 능력을 쓴다면 되지 않을까?

		// snake에 Node를 저장할거임,
		// Node는 내 숫자와 나의 이전 값을 가진다.
		// snake의 idx는 Node의 depth가 된다

		// 지금 숫자
		int now;
		// 시작점
		int left;
		// 끝점
		int right;
		// 가운데
		int mid;
		for (int i = 0; i < T; i++) {
			now = Integer.parseInt(st.nextToken());
			left = 0;
			right = length;

			while (left <= right) {
				mid = (left + right) / 2;
				if (snake[mid].data < now) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			snake[left] = new Node(now, snake[left - 1]);
			if (left == length + 1)
				length++;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(length).append('\n');
		int[] data = new int[length + 1];

		for (Node i = snake[length]; i.prev != null; i = i.prev)
			data[length--] = i.data;

		for (int i = 1; i < data.length; i++)
			sb.append(data[i]).append(' ');

		System.out.println(sb);
	}

	static class Node {
		int data;
		Node prev;

		public Node(int data, Node prev) {
			super();
			this.data = data;
			this.prev = prev;
		}
	}
}
