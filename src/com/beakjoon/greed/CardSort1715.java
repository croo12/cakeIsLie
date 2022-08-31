package com.beakjoon.greed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardSort1715 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		InnerHeap heap = new InnerHeap(n);
		
		for (int i = 0; i < n; i++) {
			heap.add(Integer.parseInt(br.readLine())); 
		}
		
		int sum = 0;
		int now;
		while(!heap.isEmpty()) {
			now = heap.delete();
			
			if(heap.isEmpty())
				break;
			
			now += heap.delete();
			sum += now;
			heap.add(now);
		}
		
		System.out.println(sum);
	}
	
	static class InnerHeap {
		final int MAX_SIZE;
		int[] heap;
		int size;

		public InnerHeap(int n) {
			this.heap = new int[n + 1];
			this.size = 0;
			this.MAX_SIZE = n;
		}

		public boolean isEmpty() {
			return size == 0;
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
			if (heap[idx] < heap[idx / 2]) {
				tmp = heap[idx];
				heap[idx] = heap[idx / 2];
				heap[idx / 2] = tmp;
				addSort(idx / 2);
			}
		}

		public int peek() {
			if (size == 0) {
				return Integer.MAX_VALUE;
			}
			
			return heap[1];
		}
		
		public int delete() {
			if (size == 0) {
				return Integer.MAX_VALUE;
			}

			int data = heap[1];
			heap[1] = heap[size];
			heap[size] = 0;
			size--;
			deleteSort(1);

			return data;
		}

		private void deleteSort(int idx) {
			int left = Integer.MAX_VALUE;
			int right = Integer.MAX_VALUE;

			if (idx * 2 <= size)
				left = heap[idx * 2];
			if (idx * 2 + 1 <= size)
				right = heap[idx * 2 + 1];

			if ((left == Integer.MAX_VALUE && right == Integer.MAX_VALUE) || (left >= heap[idx] && right >= heap[idx]))
				return;

			int tmp;

			if (left < right) {
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
	}
}
