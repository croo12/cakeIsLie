package com.elses.test;

import java.util.Scanner;

public class Test {

	public class Node<E> {
		public E data;
		public Node<E> next;

		public Node(E data) {
			this.data = data;
		}
	}

	public class LinkedQueue<E> {
		Node<E> front;
		Node<E> rear;
		int size;

		public boolean isEmpty() {
			if (front == null)
				return true;
			return false;
		}

		// enQueue
		public void enQueue(E data) {
			Node<E> now = new Node<E>(data);

			if (front == null) {
				front = now;
				rear = front;
				size++;
				return;
			}

			rear.next = now;
			rear = now;
			size++;

		}

		// deQueue
		public E deQueue() {
			if (front == null)
				return null;

			E data = front.data;
			front = front.next;
			if (front == null)
				rear = front;

			size--;
			return data;
		}

		// printQue
		public void printQue() {
			StringBuilder sb = new StringBuilder();
			if (front == null) {
				System.out.println("텅 빈 큐");
				return;
			}

			Node<E> now = front;
			for (int i = 0; i < size; i++) {
				sb.append(now.data).append(" ");
				now = now.next;
			}
			sb.setLength(sb.length() - 1);
			sb.append("\n");
			System.out.print(sb);
		}
	}

	public static void main(String[] args) {
		Test me = new Test();
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 10; tc++) {
			LinkedQueue<Integer> q = me.new LinkedQueue<>();
			int T = sc.nextInt();

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < 8; i++) {
				int now = sc.nextInt();
				q.enQueue(now);
				min = Math.min(min, now);
			}

			int div = (min - 1) / 15;

			for (int i = 0; i < 8; i++) {
				q.enQueue(q.deQueue() - (15 * div));
			}

			int minus = 0;
			boolean flag = true;
			while (flag) {
				int now = q.deQueue() - (minus++ % 5 + 1);

				if (now <= 0) {
					now = 0;
					flag = false;
				}

				q.enQueue(now);
			}

			System.out.printf("#%d ", T);
			q.printQue();

		}
		sc.close();
	}
}
