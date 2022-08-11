package com.beakjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SelectCard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
//		System.out.println(q);
		
		boolean flag = false;
		
		while(q.size() != 1) {
			if(flag) q.offer(q.peek());
			q.remove();
			flag = !flag;
		}
		
		System.out.println(q.peek());
		
		
// *밑은 짝수 일 때에만 true;		
//		int result = 0;
//		int doubleTime = 1;
//		while(result == 0) {
//			
//			int cnt = 0;
//			
//			for (int i = doubleTime; i <= N; i += doubleTime) {
//				if(cnt > 1) break;
//				cnt++;
//			}
//			
//			if(cnt == 1)
//				result = doubleTime;
//			else
//				doubleTime *= 2;
//			
//		}
//		System.out.println(result);
	}
}
