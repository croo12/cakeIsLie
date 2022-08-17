package com.beakjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusProblem1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		int cnt = 0;
		
		StringBuilder deadpool = new StringBuilder();
		deadpool.append("<");
		
		while(!q.isEmpty()) {
			cnt++;
			int now = q.poll();
			if(cnt != k) {
				q.add(now);
			}else {
				deadpool.append(now);
				if(!q.isEmpty())
					deadpool.append(", ");
				cnt = 0;
			}
		}
		deadpool.append(">");
		System.out.println(deadpool);
		sc.close();
	}
}
