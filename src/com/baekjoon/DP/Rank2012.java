package com.baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Rank2012 {
	public static void main(String[] args) {
		try {
			new Rank2012().solution();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	//1착 => 원하는 등수에 놓기 -> 자리 없으면 좌우로 한칸 무빙

	private void solution() throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		var pq = new PriorityQueue<Integer>();
		int now;
		for(int i=0; i < N; i++){
			now = Integer.parseInt(br.readLine());
			pq.offer(now);
		}

		long sum = 0L;
		for (int i=1; i<= N; i++){
			sum += Math.abs(pq.poll() - i);
		}

		System.out.println(sum);
	}
}
