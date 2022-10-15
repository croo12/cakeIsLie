package com.baekjoon.dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Deque10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		DeQ deq = new DeQ(10000);
		while(N-- > 0)
			deq.order(br.readLine());

		deq.print();
	}
	
	static class DeQ{
		final int MAX_SIZE;
		int[] q;
		int front;
		int rear;
		int size;
		StringBuilder sb;
		
		DeQ(int num){
			MAX_SIZE = num * 2 + 1;
			q = new int[num * 2 + 1];
			front = num;
			rear = num;
			size = 0;
			
			sb = new StringBuilder();
		}
		
		void order(String s) {
			String[] ss = s.split(" ");
			
			switch(ss[0]) {
			case "push_front" :
				push(Integer.parseInt(ss[1]), true);
				break;
			case "push_back" :
				push(Integer.parseInt(ss[1]), false);
				break;
			case "pop_front" :
				pop(true);
				break;
			case "pop_back" :
				pop(false);
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
		
		void push(int x, boolean front) {
			if(!front) {
				q[this.rear++] = x;
			}else {
				q[--this.front] = x;
			}
			
			size++;
		}
		
		void pop(boolean front) {
			int data;
			if(size == 0)
				data = -1;
			else {
				if(front)
					data = q[this.front++];
				else
					data = q[--this.rear];
				size--;
			}
			sb.append(data).append('\n');
		}
		
		void print() {
			System.out.print(sb);
		}
		
	}
}
