package com.baekjoon.dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Queue10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Q q = new Q(10000);
		while(N-- > 0)
			q.order(br.readLine());
		q.print();
	}
	
	static class Q{
		final int MAX_SIZE;
		int[] q;
		int front;
		int rear;
		int size;
		StringBuilder sb;
		
		Q(int num){
			MAX_SIZE = num + 1;
			q = new int[num];
			front = 0;
			rear = 0;
			size = 0;
			
			sb = new StringBuilder();
		}
		
		void order(String s) {
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
			case "push" :
				push(Integer.parseInt(ss[1]));
				break;
			case "pop" :
				pop();
				break;
			case "size" :
				sb.append(size).append('\n');
				break;
			case "empty":
				sb.append(size == 0 ? 1: 0).append('\n');
				break;
			case "front":
				if(size == 0)
					sb.append(-1).append('\n');
				else
					sb.append(q[front]).append('\n');
				break;
			case "back":
				if(size == 0)
					sb.append(-1).append('\n');
				else
					sb.append(q[rear-1]).append('\n');
				break;
			}
		}
		
		void push(int x) {
			q[rear++] = x;
			size++;
		}
		
		void pop() {
			int data;
			if(size == 0)
				data = -1;
			else {
				data = q[front++];
				size--;
			}
			sb.append(data).append('\n');
		}
		
		void print() {
			System.out.print(sb);
		}
		
	}
}
