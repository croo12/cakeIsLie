package com.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Heap {

	public static void main(String[] args) throws IOException {
		Heap me = new Heap();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			int n = Integer.parseInt(br.readLine());
			InnerHeap heap = me.new InnerHeap(n);

			StringTokenizer st;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				if (Integer.parseInt(st.nextToken()) == 1) {
					heap.add(Integer.parseInt(st.nextToken()));
				} else {
					sb.append(heap.delete()).append(" ");
				}

				System.out.println(heap);
			}

			System.out.println(sb);
		}
	}

	class InnerHeap {
		final int MAX_SIZE;
		int[] heap;
		int size;

		public InnerHeap(int n) {
			this.heap = new int[n + 1];
			this.MAX_SIZE = n;
		}

		public void add(int data) {
			if (size == 0) {
				size++;
				heap[1] = data;
				return;
			}

			if (size == MAX_SIZE) {
				System.out.println("힙이 꽉 차 있음");
				return;
			}

			size++;
			heap[size] = data;
			addSort(size);
		}

		private void addSort(int idx) {
			if (idx == 1)
				return;
			int tmp;
			if (heap[idx] > heap[idx / 2]) {
				tmp = heap[idx];
				heap[idx] = heap[idx / 2];
				heap[idx / 2] = tmp;
				addSort(idx / 2);
			}
		}

		public int delete() {
			if (size == 0) {
				System.out.println("힙이 텅 비어있음");
				return -1;
			}

			int data = heap[1];
			heap[1] = heap[size];
			heap[size] = 0;
			size--;
			deleteSort(1);

			return data;
		}

		private void deleteSort(int idx) {
			int left = 0;
			int right = 0;

			if (idx * 2 <= size)
				left = heap[idx * 2];
			if (idx * 2 + 1 <= size)
				right = heap[idx * 2 + 1];

			if ((left == 0 && right == 0) || (left <= heap[idx] && right <= heap[idx]))
				return;

			int tmp;

			if (left > right) {
				tmp = heap[idx];
				heap[idx] = heap[idx * 2];
				heap[idx * 2] = tmp;
				deleteSort(idx * 2);
			} else {
				tmp = heap[idx];
				heap[idx] = heap[idx * 2 + 1];
				heap[idx * 2 + 1] = tmp;
				deleteSort(idx * 2 + 1);
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			int stair = 2;
			for (int i = 1; i <= size; i++) {
				if (i == stair) {
					sb.append("\n");
					stair *= 2;
				}
				sb.append(heap[i]).append(" ");
			}
			return sb.toString();
		}
	}
}
