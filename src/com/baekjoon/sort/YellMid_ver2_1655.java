package com.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class YellMid_ver2_1655 {
	//틀린이유
	//1 : LinkedList 가운데부터 하는 삽입정렬 느리네 이거
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		//2착 :
		//중간 힙을 만들 수 있을까?
		//생각해보니 좌우로 힙이 있으면 중간힙이지
		
		MidHeap mh = new MidHeap();
		
		for (int i = 0; i < N; i++) {
			mh.add(Integer.parseInt(br.readLine()));
			sb.append(mh.peek()).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static class MidHeap{
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		
		void add(int x) {
			if(left.size() == right.size()) {
				left.offer(x);
			}else {
				right.offer(x);
			}
			
			while(right.peek() != null && left.peek() > right.peek()) {
				right.offer(left.poll());
				left.offer(right.poll());
			}
		}
		
		int peek() {
			return left.peek();
		}
	}
}
